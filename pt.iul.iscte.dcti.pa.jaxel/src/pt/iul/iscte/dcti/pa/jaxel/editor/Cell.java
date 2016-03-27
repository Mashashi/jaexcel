package pt.iul.iscte.dcti.pa.jaxel.editor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.editor.CellInterval.IntervalException;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionConstants;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

public class Cell {
	
	public final int line;
	public final String column;
	private static Evaluator evaluator;
	
	public static final Pattern CELL_REFERENCE = Pattern.compile("#[A-Z]+[0-9]+");
	public static final String CELL_COMPONENT_PARSING = "^#([A-Z]+)([0-9]+)$";
	
	public static final int BASE = 26;
	
	public Cell(int line, String column) {
		/*if(line<1 || !column.matches("[A-Z]+"))
			throw new IllegalArgumentException();*/
		this.line = line;
		this.column = column;
	}
	@Override
	public boolean equals(Object toCompare) {
		if(!(toCompare instanceof Cell))
			throw new IllegalArgumentException();
		return ((Cell)toCompare).column.equals(column) && ((Cell)toCompare).line==line;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + line;
		result = 31 * result + column.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return column+line;
	}
	
	/**
	 * Parses an expression
	 * 
	 * @param strExpr The expression taken from the cell
	 * @param sheet The sheet the expression string refers to
	 * @see Cell#getValueOfCell(Cell, Table)
	 * @return The result of the parse operation
	 * @throws EvaluationException 
	 * @throws IntervalException 
	 */
	public static String evaluateExpression(ViewTable viewTable, String strExpr, Table sheet) throws EvaluationException, IntervalException{
		String returnedValue = "";
		if(!strExpr.isEmpty()){	
			if(strExpr.charAt(0)!='='){
				returnedValue=strExpr;
			}else{
				List<CellInterval> cellIntervals = CellInterval.getCellInterval(strExpr);
				for(CellInterval cellInterval: cellIntervals){
					//System.out.println(cellInterval);
					strExpr=strExpr.replace("#"+cellInterval.toString(), cellInterval.getValueOfCellInterval(sheet));
				}
				
				List<Cell> cells = getCells(strExpr);
				for(Cell cell:cells){
					strExpr=strExpr.replace("#"+cell.toString(), cell.getValueOfCell(sheet));
				}
				returnedValue = getEvaluator(viewTable, true).evaluate(strExpr.substring(1));
			}
		}
		return returnedValue;
	}
	public String getValueOfCell(Table sheet) throws EvaluationException{
		Sheet dataObj =((Sheet)(sheet.getData()));
		int columnNumber = getCorrespondenceColumnNumber();
		if(columnNumber>=dataObj.getNumberOfColumns()||columnNumber<0)
			throw new EvaluationException("");
		if(line>dataObj.getNumberOfRows()||line<0)
			throw new EvaluationException("");
		int columnNum = getCorrespondenceColumnNumber()+1;
		TableItem item = null;
		try{
			item = sheet.getItem(line-1);
		}catch(IllegalArgumentException e){
			throw new EvaluationException("");
		}
		String strVal = item.getText(columnNum);
		return strVal;
	}
	
	
	
	
	/**
	 * Gets the next code label of a column
	 * 
	 * @param label 
	 * @return
	 */
	public static String getNextLabel(String label){
	
		if(!label.matches("^[A-Z]*$"))
			throw new IllegalArgumentException("Label takes value: '"+label+"'");
	
		String next = "A";
	
		if(label.length()!=0){
			char c = label.charAt(label.length()-1);
			int next_char = ((int)c)+1;
			if(next_char>(int)'Z'){
				if(label.length()>1){
					next = getNextLabel(label.substring(0, label.length()-1))+"A";
				}else{
					next="AA";
				}
			}else{
				next=label.substring(0, label.length()-1)+((char)next_char);
			}
		}
		return next;
	}
	
	/**
	 * Get the cells used in a expression
	 * 
	 * @param strExpr Target expression 
	 * @return A list of Cell objects
	 */
	public static List<Cell> getCells(String strExpr){
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Matcher matcher = CELL_REFERENCE.matcher(strExpr);
		
		while(matcher.find()){
			String temp = matcher.group();		
			String column = temp.replaceAll(CELL_COMPONENT_PARSING, "$1");
			int line = Integer.parseInt(temp.replaceAll(CELL_COMPONENT_PARSING, "$2"));
			if(line>=1 && column.matches("[A-Z]+")){
				Cell bufferCell =  new Cell(line, column);
				if(!cells.contains(bufferCell)){
					cells.add(bufferCell);
				}
			}
		}
		return cells;
	}
	
	
	
	/**
	 * Get the column number by its column code
	 * A simple base conversion
	 * @param columnCode
	 * @return
	 */
	public int getCorrespondenceColumnNumber(){
		int result = 0;
		for(int i=0;i<column.length();i++){
			result += (column.charAt(i)-((int)'A'))*Math.pow(BASE, i);
		}
		return result;
	}
	
	public static Evaluator getEvaluator(ViewTable viewTable, boolean newEvaluator){
		if(newEvaluator||evaluator==null){
			Cell.evaluator = new Evaluator('\'',
                true	/*loadMathVariables*/,
                true	/*loadMathFunctions*/,
                false	/*loadStringFunctions*/,
                true	/*processNestedFunctions*/);
			
			
			
			if(viewTable.methodGetter!=null){
			for(final Entry<Class<?>, Method> method: viewTable.methodGetter.methodsRead){
				
				Cell.evaluator.putFunction(new Function() {
					
					public static final String ELEMENT = "((-)?[0-9]+(\\.[0-9]+)?)";
					public static final String ELEMENT_ARRAY = ELEMENT+"(&"+ELEMENT+")*";
					public static final String ARRAY = "^'(("+")|("+ELEMENT_ARRAY+"))'$";
					//public static final String ARRAY = "^'"+ELEMENT+"'$";
					
					@Override
					public String getName() {
						String name = method.getKey().getName()+"."+method.getValue().getName();
						return name;
					}
					
					@Override
					public FunctionResult execute(Evaluator evaluator, String arguments) throws FunctionException {
						
						@SuppressWarnings("unchecked")
						List<String> parsedStrings = FunctionHelper.getStrings(arguments, ',');
						
						Class<?>[] paramsTypes = method.getValue().getParameterTypes();
						Object[] paramsParsed = new Object[paramsTypes.length];
						
						if(parsedStrings.size()!=paramsTypes.length){
							throw new FunctionException("Number of arguments does not match");
						}
						
						int pos = 0;
						for(Class<?> clazz: paramsTypes){
							if(clazz.equals(Integer[].class)||clazz.equals(Double[].class)){
								if(parsedStrings.get(pos).matches(ARRAY)){
									String arrayWithNoQuotes = FunctionHelper.trimAndRemoveQuoteChars(parsedStrings.get(pos), evaluator.getQuoteCharacter());
									@SuppressWarnings("unchecked")
									ArrayList<String> elements = FunctionHelper.getStrings(arrayWithNoQuotes, '&');
									Object[] array = null;								
									
									if(clazz.equals(Integer[].class)){
										array = new Integer[elements.size()];
									}else if(clazz.equals(Double[].class)){
										array =  new Double[elements.size()];
									}
									
									for(int i=0; i<elements.size();i++){
										String strBuf = elements.get(i);
										if(clazz.equals(Integer[].class)){
											int indexPoint = strBuf.indexOf('.');
											if(indexPoint==-1){
												indexPoint = strBuf.length();
											}
											array[i] = Integer.parseInt(strBuf.substring(0,indexPoint));
										}else{
											array[i] = Double.parseDouble(strBuf);
										}
									}
									paramsParsed[pos] = array;
								}
							}else if(!parsedStrings.get(pos).matches("^(-)?[0-9]+(\\.[0-9]*)?$")){
								if(clazz.equals(Integer.class)){
									String strBuf = parsedStrings.get(pos);
									int indexPoint = strBuf.indexOf('.');
									if(indexPoint==-1){
										indexPoint=strBuf.length();
									}
									String toConvert = strBuf.substring(0,indexPoint);
									paramsParsed[pos] = Integer.parseInt(toConvert);
								}else if(clazz.equals(Double.class)){
									paramsParsed[pos] = Double.parseDouble(parsedStrings.get(pos));
								}else{
									throw new FunctionException("Argument type not supported");
								}
							}else{
								throw new FunctionException("The parameter is not numeric");
							}
							pos++;
							
						}
						
						Object result;
						try {
							result = method.getValue().invoke(method.getKey(), paramsParsed);
						} catch (IllegalAccessException
								| IllegalArgumentException
								| InvocationTargetException e) {
							throw new FunctionException("Error while evaluating expression", e);
						}
						
						return new FunctionResult(result.toString(), FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
					}
				});
				
			}
			}
			
			
			
		}
		return Cell.evaluator;
	}
	
}







/*
 * Translates the cell number into a cell code
 * 
 * @param columnNumber From 1 to Infinity
 * @return The code of the column number. For instances to one it would return A.
 *
	public static String getCorrespondentColumnCode(int columnNumber){
	StringBuilder code = new StringBuilder("");
	int temporaryNumberOfColumns = columnNumber;
	do{
		columnNumber=temporaryNumberOfColumns;
		int converted = (columnNumber%BASE);
		char resultChar = (char)( (((int)'A')-1) +converted);
		code.append(resultChar);
		temporaryNumberOfColumns=columnNumber/BASE;
	}while(columnNumber/BASE!=0);
	code = code.reverse();
	
	int index = code.indexOf("@");
	while(index!=-1){
		int c = code.codePointBefore(index);
		char ch =((char)(c-1));
		if((ch+"").matches("^[A-Z]$")){
			code.setCharAt(index-1, ch);
		}else{
			code.deleteCharAt(index-1);
			index--;
		}
		code.setCharAt(index, 'Z');
		index=code.indexOf("@", index);
	}
	return code.toString();
}*/