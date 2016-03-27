package pt.iul.iscte.dcti.pa.jaxel.command;

import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;

import pt.iul.iscte.dcti.pa.jaxel.Sheet;

public class RenameSheetCommand implements ICommand{

	private TabItem sheet;
	private String oldName;
	private String newName;
	
	public RenameSheetCommand(TabItem sheet, String newName){
		this.sheet = sheet;
		oldName = null;
		this.newName = newName;  
	}
	
	@Override
	public void execute() {
		if(oldName==null){
			oldName = sheet.getText(); 
			sheet.setText(newName);
			((Sheet)((Table)(sheet.getControl())).getData()).setName(newName);
		}
	}

	@Override
	public void undo() {
		if(oldName!=null){
			sheet.setText(oldName);
			((Sheet)((Table)(sheet.getControl())).getData()).setName(oldName);
			oldName = null; 
		}
	}

}
