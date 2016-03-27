package pt.iul.iscte.dcti.pa.jaxel.observer.events;

import org.eclipse.swt.widgets.Table;

import pt.iul.iscte.dcti.pa.jaxel.observer.EEventType;
import pt.iul.iscte.dcti.pa.jaxel.observer.EventDetails;
import pt.iul.iscte.dcti.pa.jaxel.observer.IEventListener;


public abstract class CellChangedListener implements IEventListener{
	
	private final Table table; 
	private final int line;
	private final String column; 
	
	public CellChangedListener(Table table, int line, String column){
		this.table  = table;
		this.line	= line;
		this.column	= column;
	}
	
	@Override
	public void handleEvent(EventDetails eventDetails) {
		if(eventDetails.eventType.equals(EEventType.SHEET_VALUE_CHANGED)){
			cellChangedListener( (Table)eventDetails.extraData[0], (Integer)eventDetails.extraData[1], 
					(String)eventDetails.extraData[2], (String)eventDetails.extraData[3], (Integer)eventDetails.extraData[4]);
		}
	}
	
	public abstract void cellChangedListener(Table tableUpdated, int lineUpdated, String columnUpdated, String newValueUpdated, int loopDetection);
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CellChangedListener))
			throw new IllegalArgumentException();
		CellChangedListener input = (CellChangedListener)obj;
		return input.table.equals(table) && input.line==line && input.column.equals(column);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + line;
		result = 31 * result + column.hashCode();
		result = 31 * result + table.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		return "Originator ( table: "+table.hashCode()+" "+line+" "+column+")";
	}
}
