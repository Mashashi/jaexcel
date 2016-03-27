package pt.iul.iscte.dcti.pa.jaxel.extensions;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;

public interface ISheetMenu {
	
	SelectionListener getSelectionListener(Table selectedTable);
	
}
