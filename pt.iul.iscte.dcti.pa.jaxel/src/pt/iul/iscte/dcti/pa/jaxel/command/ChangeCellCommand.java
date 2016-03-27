package pt.iul.iscte.dcti.pa.jaxel.command;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.sourceforge.jeval.EvaluationException;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import pt.iul.iscte.dcti.pa.jaxel.CellColumn;
import pt.iul.iscte.dcti.pa.jaxel.Row;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.editor.Cell;
import pt.iul.iscte.dcti.pa.jaxel.editor.CellInterval;
import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;
import pt.iul.iscte.dcti.pa.jaxel.editor.CellInterval.IntervalException;
import pt.iul.iscte.dcti.pa.jaxel.observer.EEventType;
import pt.iul.iscte.dcti.pa.jaxel.observer.events.CellChangedListener;

public class ChangeCellCommand implements ICommand{
	
	private String oldValue;
	private String newValue;
	
	private int lineIndex;
	private int columnNumber;
	
	private Sheet sheet;
	
	private ViewTable viewTable;
	
	public ChangeCellCommand(String nextValue, int lineIndex, int columnNumber, Sheet sheet, ViewTable viewTable){
		this.newValue = nextValue;
		this.lineIndex = lineIndex;
		this.columnNumber = columnNumber;
		this.sheet = sheet;
		this.viewTable = viewTable;
	}
	
	@Override
	public void execute() {
		if(oldValue==null){
			setValueInToCell(newValue, lineIndex, columnNumber, sheet);
		}
	}

	@Override
	public void undo() {
		if(oldValue!=null){
			setValueInToCell(oldValue, lineIndex, columnNumber, sheet);
			oldValue=null;
		}
	}
	
	private Table getTableFromSheet(Sheet sheet){
		TabItem[] sheets = viewTable.tabFolder.getItems();
		for(TabItem sheetTemp: sheets){
			//Table table = ((Table)((TabItem)sheetTemp).getControl());
			if(!sheetTemp.isDisposed()){
				if( sheetTemp.getControl().getData().equals(sheet) ){
					return (Table)sheetTemp.getControl();
				}
			}
		}
		return null;
	}
	
	/**
	 * Sets the value of the global variable oldValue
	 * 
	 * @param str
	 * @param lineIndex
	 * @param columnNumber
	 * @param selectedSheet
	 */
	private void setValueInToCell(String str, final int lineIndex,final int columnNumber, final Sheet selectedSheet){
		
		final Table selectedTable = getTableFromSheet(selectedSheet);
		
		if(str==null || columnNumber>selectedTable.getItemCount() || columnNumber>selectedTable.getColumnCount()){
			throw new IllegalArgumentException();
		}
		
		final String columnLabel = selectedTable.getColumns()[columnNumber].getText();
		final TableItem item = selectedTable.getItem(lineIndex);
		final String cellLabel = "("+columnLabel+(lineIndex+1)+")";
		
		//MODEL
		Row row = (Row) item.getData();
		if(row==null){
			row = viewTable.factory.createRow();
			//(Integer)item.getParent().indexOf(item)
			((Sheet)item.getParent().getData()).getRows().put((Integer)lineIndex, row);
			item.setData(row);
		}
		
		CellColumn elem = row.getColumns().get((Integer)columnNumber);
		//Element elem2 = ((Sheet)selectedTable.getData()).getRow_sheet().get(lineIndex).getElements().get(columnNumber);
		if(elem==null){
			elem = viewTable.factory.createCellColumn();
			elem.setValue("");
			elem.setResult("");
		}
		
		oldValue = elem.getValue();
			
		if(str.equals(elem.getValue()) && str.equals("")){
			if(row.getColumns().size()==0){
				((Sheet)item.getParent().getData()).getRows().remove((Integer)lineIndex);
				item.setData(null);
			}
		}else{
			// If newValue is different from oldValue...
			elem.setResult(str);
			if(!str.isEmpty() && str.charAt(0)=='='){
				// If is a formula...
				Set<Cell> cellsNew = new HashSet<Cell>();
				List<Cell> listCellsNew = new LinkedList<Cell>();
				
				String result = "N/A";
			
				String parsedIntervals = str;
				try {
					cellsNew.addAll(CellInterval.getCellListFromCellIntervalList(CellInterval.getCellInterval(parsedIntervals)));
				} catch (IntervalException e) {
					//e.printStackTrace();
					parsedIntervals = CellInterval.replaceUnvalidIntervals(parsedIntervals, "N/A");
				}
				cellsNew.addAll(Cell.getCells(parsedIntervals));
				listCellsNew.addAll(cellsNew);
				
				delListenersToCellsNotRef(selectedTable, lineIndex, columnNumber, elem, listCellsNew);
				
				try {
					try {
						result = Cell.evaluateExpression(viewTable, str, selectedTable);
					}catch(EvaluationException e){
						//e.printStackTrace();
					}
					setListenersToCellsRef(lineIndex, selectedTable, item, columnNumber, elem, listCellsNew, cellLabel, columnLabel, viewTable);
				} catch (CellInterval.IntervalException e) {
					//e.printStackTrace();
				}
				
				elem.setResult(result);
				
				
			}
			
			if(str.isEmpty()){
				delListenersToCellsNotRef(selectedTable, lineIndex, columnNumber, elem, new LinkedList<Cell>());
				row.getColumns().remove((Integer)columnNumber);
				if(row.getColumns().size()==0){
					((Sheet)item.getParent().getData()).getRows().remove((Integer)lineIndex);
					item.setData(null);
				}
			}else{
				row.getColumns().put((Integer)columnNumber, elem);
			}
			
			elem.setValue(str);
			item.setText(columnNumber, elem.getResult());
			
			viewTable.observable.newEvent(EEventType.SHEET_VALUE_CHANGED, 
					new Object[]{selectedTable, (lineIndex+1), selectedTable.getColumns()[columnNumber].getText(), elem.getResult(), 0});
			
			viewTable.cellFormula.setText(selectedTable.getColumns()[columnNumber].getText()+(lineIndex+1));
			viewTable.formula.setText(elem.getValue());
			
		}
	}
	
	public static void setListenersToCellsRef(final int lineIndex,
			final Table selectedTable, final TableItem line,
			final int columnNumber, CellColumn elem, List<Cell> cellsNew,
			final String cellLabel, final String columnLabel, final ViewTable viewTable) {
		
		//Set listeners
		final CellColumn elemToParse = elem;
		for(Cell cell:cellsNew){
			final Cell cellToListen = cell;
			//Listener to the referenced cell
			CellChangedListener newObserver = new CellChangedListener(
					selectedTable,lineIndex,selectedTable.getColumns()[columnNumber].getText()) {
				@Override
				public void cellChangedListener(Table tableUpdated, int lineUpdated,
						String columnUpdated, String newValue, int loopDetection) {
					if(selectedTable.equals(tableUpdated) && cellToListen.line==lineUpdated){
						//Same sheet and Same Line
						if(cellToListen.column.equals(columnUpdated)){
							//Same Column
							String newResult = null;
							try {
								newResult = Cell.evaluateExpression(viewTable, elemToParse.getValue(), selectedTable);
							} catch (EvaluationException|IntervalException e) {
								newResult="N/A";
							}
							System.out.println(cellLabel+" Parsing: "+elemToParse.getValue()+", Parsed: "+newResult+", loop: "+(loopDetection+1));
							line.setText(columnNumber, newResult);
							
							EMap<Integer, CellColumn> columns = ((Row)line.getData()).getColumns();
							CellColumn columnTemp = columns.get((Integer)columnNumber);
							columnTemp.setResult(newResult);
							
							if(loopDetection<ViewTable.MAXIMUM_LOOP_DETECTION_FORMULA_ITERATION){
								viewTable.observable.newEvent(EEventType.SHEET_VALUE_CHANGED, new Object[]{selectedTable, (lineIndex+1), columnLabel, newResult, loopDetection+1});
							}else{
								MessageBox dialog = new MessageBox(viewTable.getShell(), SWT.ERROR);
								dialog.setText("Loop Detection");
								dialog.setMessage("The threshold of "+ViewTable.MAXIMUM_LOOP_DETECTION_FORMULA_ITERATION+" there for a loop was detected");
								dialog.open();
							}
							
						}
					}
				}
			};
			//See if listener to the referenced cell is already set
			Set<CellChangedListener> setListenersCell = viewTable.mappedListeners.get(selectedTable.getData()).get(cell);
			if(!setListenersCell.contains(newObserver)){
				viewTable.mappedListeners.get(selectedTable.getData()).put(cell, newObserver);
				viewTable.observable.addListener(newObserver);
				System.out.println(cellLabel+" Listener add to "+cell);
			}else{
				System.out.println(cellLabel+" Listener already registered to cell "+cell);
			}
		}
	}
	
	private void delListenersToCellsNotRef(Table selectedTable,
			int lineIndex, int columnNumber, CellColumn elem,
			List<Cell> cellsNew) {
		//Delete listeners to cells no longer referenced
		
		Set<Cell> cellsOld = new HashSet<Cell>();
		try {
			cellsOld.addAll(CellInterval.getCellListFromCellIntervalList(CellInterval.getCellInterval(elem.getValue())));
		} catch (IntervalException e) {
			//e.printStackTrace();
		}
		cellsOld.addAll(Cell.getCells(elem.getValue()));
		List<Cell> listCellsOld = new LinkedList<Cell>();
		listCellsOld.addAll(cellsOld);
		
		String columnLabel = selectedTable.getColumns()[columnNumber].getText(); 
		for(Cell cellOld:listCellsOld){
			if(!cellsNew.contains(cellOld)){
				// Delete listener to cell
				CellChangedListener toRemove = new CellChangedListener(selectedTable, lineIndex, columnLabel){
					@Override
					public void cellChangedListener(
							Table tableUpdated, int lineUpdated,
							String columnUpdated,
							String newValueUpdated,
							int loopDetection) {}
				};
				if(viewTable.mappedListeners.get(selectedTable.getData()).get(cellOld).remove(toRemove) && viewTable.observable.removeListener(toRemove)){
					String cellLabel =  "("+columnLabel+(lineIndex+1)+")";
					System.out.println(cellLabel+" Listener taken from "+cellOld+" listener "+toRemove);
				}
			}
		}
	}
	
}
