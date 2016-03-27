package pt.iul.iscte.dcti.pa.jaxel.command;

import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;

import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;

public class DeleteSheetCommand implements ICommand{
	
	//TabItem
	private Object[] items;
	private ViewTable viewTable;
	private Sheet[] sheets;
	
	public DeleteSheetCommand(ViewTable folder, Object[] sheets){
		this.items = sheets;
		this.viewTable = folder;
	}
	
	@Override
	public void execute() {
		if(sheets==null){
			int pos = 0;
			sheets = new Sheet[items.length];
			for(Object item :items){
				Sheet deletedSheet = (Sheet) ((Table)((TabItem)item).getControl()).getData();
				sheets[pos] = deletedSheet;
				pos++;
				((Document)viewTable.tabFolder.getData()).getSheet_file().remove(deletedSheet);
				((TabItem)item).dispose();
			}
		}
	}

	@Override
	public void undo() {
		if(sheets!=null){
			for(Sheet sheet:sheets){
				viewTable.addSheet(sheet, true, true);
			}
			viewTable.layout();
			sheets=null;
		}
	}

}
