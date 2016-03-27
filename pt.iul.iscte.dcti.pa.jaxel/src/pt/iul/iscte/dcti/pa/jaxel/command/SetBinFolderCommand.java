package pt.iul.iscte.dcti.pa.jaxel.command;

import java.io.File;

import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.DynamicMethodGetter;
import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;

public class SetBinFolderCommand implements ICommand{
	
	private String newTip;
	private String newPath;
	
	private String oldTip;
	private String oldPath;
	
	private ViewTable viewTable;
	private Boolean oldRefreshEnabled;
	
	public SetBinFolderCommand(ViewTable viewTable, String newTip, String newPath){
		this.newTip = newTip;
		this.newPath = newPath;
		
		this.viewTable = viewTable;
		this.oldTip = null;
		this.oldRefreshEnabled = null;
	}
	
	@Override
	public void execute() {
		if(oldTip==null){
			oldTip = viewTable.armListnerSetBinFolder.tip;
			oldPath = viewTable.armListnerSetBinFolder.path;
			
			viewTable.setToolTipSetBinFolder(newTip, newPath);
			viewTable.methodGetter = new DynamicMethodGetter(ViewTable.class.getClassLoader(), new File(newPath));
			viewTable.methodGetter.getAllValidMethods();
			((Document)viewTable.tabFolder.getData()).setBinFolder(newPath);
			oldRefreshEnabled = viewTable.refreshBinPath.getEnabled();
			viewTable.refreshBinPath.setEnabled(true);
		}
	}

	@Override
	public void undo() {
		if(oldTip!=null){
			viewTable.setToolTipSetBinFolder(oldTip, oldPath);
			viewTable.methodGetter = new DynamicMethodGetter(ViewTable.class.getClassLoader(), new File(oldPath));
			viewTable.methodGetter.getAllValidMethods();
			((Document)viewTable.tabFolder.getData()).setBinFolder(oldPath);
			viewTable.refreshBinPath.setEnabled(oldRefreshEnabled);
		}
	}

}
