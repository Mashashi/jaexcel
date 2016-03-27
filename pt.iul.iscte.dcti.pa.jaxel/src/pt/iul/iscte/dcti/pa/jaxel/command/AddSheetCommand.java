package pt.iul.iscte.dcti.pa.jaxel.command;

import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;

import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;

public class AddSheetCommand implements ICommand{
	
	private Sheet sheet;
	private ViewTable viewTable;
	private TabItem insertedTabItem;
	
	public AddSheetCommand(ViewTable viewTable, Sheet sheet){
		this.sheet = sheet;
		this.viewTable = viewTable;
	}
	
	@Override
	public void execute() {
		if(insertedTabItem==null){
			insertedTabItem=viewTable.addSheet(sheet, false, true);
			viewTable.layout();
		}
	}

	@Override
	public void undo() {
		if(insertedTabItem!=null){
			Sheet deletedSheet = (Sheet) ((Table)(insertedTabItem.getControl())).getData();
			((Document)viewTable.tabFolder.getData()).getSheet_file().remove(deletedSheet);
			insertedTabItem.dispose();
			insertedTabItem=null;
		}
	}

}
