package pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;

public class TableView extends ViewPart{
	
	public ViewTable table;
	
	@Override
	public void createPartControl(Composite parent) {
		table = new ViewTable(parent);
	}

	@Override
	public void setFocus() {
		table.setFocus();
	}

}