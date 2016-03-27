package pt.iul.iscte.dcti.pa.jaxel.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.widgets.Table;

import com.google.common.collect.Lists;

import net.sourceforge.jeval.EvaluationException;

public class CellInterval{
	
	/**
	 * Horizontal
	 * Vertical
	 * Single - If the interval only contains one element
	 * @author Rafael
	 *
	 */
	public enum Orientation { HORIZONTAL, VERTICAL, SINGLE }
			
	public final Cell startCell;
	public final Cell endCell;
	public final Orientation orientation;
	public final int size;
	
	public static final Pattern VECTOR_REFERENCE = Pattern.compile("#[A-Z]+[0-9]+:[A-Z]+[0-9]+");
	public static final String VECTOR_COMPONENT_PARSING = "^#([A-Z]+)([0-9]+):([A-Z]+)([0-9]+)$";
	
	@SuppressWarnings("serial")
	public static class IntervalException extends Exception{
		public final Cell startCell;
		public final Cell endCell;
		public IntervalException(String msg, Cell startCell, Cell endCell) {
			super(msg);
			this.startCell = startCell;
			this.endCell = endCell;
		}
		@Override
		public String toString() {
			return startCell.toString()+":"+endCell.toString();
		}
	}
	
	public CellInterval(Cell startCell, Cell endCell) throws IntervalException {
		this.startCell = startCell;
		if(!endCell.column.equals(startCell.column) && endCell.line!=startCell.line){
			throw new IntervalException("The given cells do not form a vector", startCell, endCell);
		}
		
		/*int start = startCell.getCorrespondenceColumnNumber();
		int end = endCell.getCorrespondenceColumnNumber();*/
		
		/*if(start!=end && start>end){
			throw new IntervalException("The start cell is after the end cell", startCell, endCell);
		}*/
		
		/*if(start>=sheet.getNumberOfColumns()||start<0){
			throw new IntervalException("The start cell is out of range");
		}
		if(end>=sheet.getNumberOfColumns()||end<0){
			throw new IntervalException("The end cell is out of range");
		}*/
		
		/*start = startCell.line;
		end = endCell.line;*/
		
		/*if(start!=end && start>end){
			throw new  IntervalException("The start cell is after the end cell", startCell, endCell);
		}*/
		
		/*if(start>sheet.getNumberOfRows()||start<0){
			throw new IntervalException("The start cell is out of range");
		}
		if(end>sheet.getNumberOfRows()||end<0){
			throw new IntervalException("The end cell is out of range");
		}*/
		
		this.endCell = endCell;
		this.orientation = getOritentation();
		this.size = getSize();
	}
	
	public static String replaceUnvalidIntervals(String expr, String replacement){
		boolean thrownException = true;
		do{
			try {
				getCellInterval(expr);
				thrownException = false;
			} catch (IntervalException e) {
				expr = expr.replace("#"+e.toString(), replacement);
			}
		}while(thrownException);
		return replacement;
	}
	
	public static List<CellInterval> getCellInterval(String strExpr) throws IntervalException{
		
		ArrayList<CellInterval> intervals = new ArrayList<CellInterval>();
		Matcher matcher = VECTOR_REFERENCE.matcher(strExpr);
		
		while(matcher.find()){
			String temp = matcher.group();
			
			String column = temp.replaceAll(VECTOR_COMPONENT_PARSING, "$1");
			int line = Integer.parseInt(temp.replaceAll(VECTOR_COMPONENT_PARSING, "$2"));
			Cell bufferCellStart =  new Cell(line, column);
			
			column = temp.replaceAll(VECTOR_COMPONENT_PARSING, "$3");
			line = Integer.parseInt(temp.replaceAll(VECTOR_COMPONENT_PARSING, "$4"));
			Cell bufferCellEnd =  new Cell(line, column);
			
			CellInterval bufferInterval = new CellInterval(bufferCellStart, bufferCellEnd);
			
			if(!intervals.contains(bufferInterval)){
				intervals.add(bufferInterval);
			}
		}
		return intervals;
	}
	
	public static List<Cell> getCellListFromCellIntervalList(List<CellInterval> cellIntervals){
		List<Cell> returned = new ArrayList<Cell>();
		for(CellInterval cellInterval: cellIntervals){
			returned.addAll(cellInterval.getCellList());
		}
		return returned;
	}
	
	public Orientation getOritentation(){
		if(endCell.column.equals(startCell.column) && endCell.line==startCell.line){
			return Orientation.SINGLE;
		}else if(endCell.column.equals(startCell.column)){
			return Orientation.VERTICAL;
		}else if(endCell.line==startCell.line){
			return Orientation.HORIZONTAL;
		}
		return null;
	}
	
	public int getSize(){
		switch(orientation){
			case HORIZONTAL:{
				return Math.max(endCell.getCorrespondenceColumnNumber(), startCell.getCorrespondenceColumnNumber())-Math.min(endCell.getCorrespondenceColumnNumber(), startCell.getCorrespondenceColumnNumber())+1;
			}
			case VERTICAL:{
				return Math.max(endCell.line,startCell.line)-Math.min(endCell.line,startCell.line)+1;//
			}
			case SINGLE:
		}
		return 1;
	}
	
	@Override
	public String toString() {
		return startCell+":"+endCell;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CellInterval))
			throw new IllegalArgumentException();
		CellInterval objIn = (CellInterval)obj;
		return objIn.startCell.equals(startCell) && objIn.endCell.equals(endCell);
	}
	
	public List<Cell> getCellList() {
		List<Cell> list = new LinkedList<Cell>();
		
		Cell startCell = this.startCell;
		boolean reversed = false;
		if(orientation.equals(Orientation.HORIZONTAL)){
			if(reversed = startCell.getCorrespondenceColumnNumber()>endCell.getCorrespondenceColumnNumber()){
				startCell = endCell;
			}
		}else if(orientation.equals(Orientation.VERTICAL)){
			if(reversed = startCell.line>endCell.line){
				startCell = endCell;
			}
		}
		
		String column = startCell.column;
		for(int i=0; i<size;i++){
			switch(orientation){
				case HORIZONTAL:
					list.add(new Cell(startCell.line,column));
					column = Cell.getNextLabel(column);
					break;
					
				case VERTICAL:
				case SINGLE:
					list.add(new Cell(startCell.line+i,column));
					break;
					
			}
		}
		return reversed?Lists.reverse(list):list;
	}
	
	public String getValueOfCellInterval(Table sheet) throws EvaluationException{
		StringBuilder strBuilder = new StringBuilder("");
		strBuilder.append(" ");
		
		Iterator<Cell> cellIte = this.getCellList().iterator();
		
		while(cellIte.hasNext()){
			Cell cell = cellIte.next();
			strBuilder.append(cell.getValueOfCell(sheet));
			//strBuilder.append("&");
			strBuilder.append(",");
		}
		
		//strBuilder.setCharAt(strBuilder.length()-1, '\'');
		strBuilder.deleteCharAt(strBuilder.length()-1);
		
		return strBuilder.toString().replace(" ", "");
	}
	
}
