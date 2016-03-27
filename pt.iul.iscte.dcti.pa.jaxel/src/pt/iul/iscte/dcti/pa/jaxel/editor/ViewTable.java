/**
 * 
 */
package pt.iul.iscte.dcti.pa.jaxel.editor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import com.google.common.collect.HashMultimap;

import pt.iul.iscte.dcti.pa.jaxel.DynamicMethodGetter;
import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.FileOperations;
import pt.iul.iscte.dcti.pa.jaxel.JaxelFactory;
import pt.iul.iscte.dcti.pa.jaxel.Row;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.command.AddSheetCommand;
import pt.iul.iscte.dcti.pa.jaxel.command.ChangeCellCommand;
import pt.iul.iscte.dcti.pa.jaxel.command.ICommand;
import pt.iul.iscte.dcti.pa.jaxel.command.DeleteSheetCommand;
import pt.iul.iscte.dcti.pa.jaxel.command.NoCommandCommand;
import pt.iul.iscte.dcti.pa.jaxel.command.RenameSheetCommand;
import pt.iul.iscte.dcti.pa.jaxel.command.SetBinFolderCommand;
import pt.iul.iscte.dcti.pa.jaxel.extensions.IDocumentMenu;
import pt.iul.iscte.dcti.pa.jaxel.extensions.ISheetMenu;
import pt.iul.iscte.dcti.pa.jaxel.histogram.ViewHistogram;
import pt.iul.iscte.dcti.pa.jaxel.observer.Observable;
import pt.iul.iscte.dcti.pa.jaxel.observer.events.CellChangedListener;

import org.apache.commons.collections.ArrayStack;

/**
 * @author Rafael
 *
 */
public class ViewTable extends Composite{
	
	public static String SELECTEDSHEETCONTROL_ID 	= "pt.iul.iscte.dcti.pa.jaxel.selectedsheetcontrol";
	public static String SELECTEDDOCUMENTCONTROL_ID = "pt.iul.iscte.dcti.pa.jaxel.selecteddocumentcontrol";
	
	public static final int MAXIMUM_ROWS_DEFAULT = 65536;
	public static final int MAXIMUM_COLUMNS_DEFAULT = 26;
	public static final int MAXIMUM_LOOP_DETECTION_FORMULA_ITERATION = 100;
	
	public static final int MAXIMUM_HISTORY_ITEMS = 30;
	
	private ICommand saved;
	
	// Factory for building new Model objects
	public final JaxelFactory factory;
	
	// The label element to the formula element indicating the cell that the formula refers to
	public final Label cellFormula;
	
	// The formula element that appears on top of the shell following the menus
	public final Label formula;	
	
	// The tab widget that holds an instance of table
	public TabFolder tabFolder;
	
	// Store the CellChangedListeners by observed Cell
	public HashMap<Sheet, HashMultimap<Cell, CellChangedListener>> mappedListeners;	
	public Observable observable;
	
	
	private MenuItem save;
	private MenuItem addSheet;
	private MenuItem deleteSheet;
	private MenuItem renameSheet;
	private MenuItem saveAs;
	private MenuItem setBinPath;
	public MenuItem refreshBinPath;
	
	private FileOperations file = null;
	
	public static ViewHistogram viewHistogram;
	
	public DynamicMethodGetter methodGetter;
	
	public BinFolderListener armListnerSetBinFolder;
	public class BinFolderListener implements Listener{
		public final String tip;
		public final String path;
		public BinFolderListener(String tip, String path) {
			this.tip = tip;
			this.path = path;
		}
		@Override
		public void handleEvent(Event event) {
			ToolTip toolTip = new ToolTip(getShell(), SWT.ICON_INFORMATION);
			toolTip.setText(tip);
			toolTip.setVisible(true);
		}
	}
	public BinFolderListener setToolTipSetBinFolder(final String tip, final String path){
		if(armListnerSetBinFolder!=null){
        	setBinPath.removeListener(SWT.Arm, armListnerSetBinFolder);
        }
        armListnerSetBinFolder = new BinFolderListener(tip, path);
        setBinPath.addListener(SWT.Arm, armListnerSetBinFolder);
        return armListnerSetBinFolder;
	}
	
	
	
	
	private ArrayStack historyPass;
	private ArrayStack historyFuture;
	
	
	
	
	public void pushAndExecute(ICommand cmd) {
		if(historyPass.size()==MAXIMUM_HISTORY_ITEMS){
			historyPass.remove(0);
		}
		this.historyPass.push(cmd);
		cmd.execute();
		if(file!=null){
			save.setEnabled(true);
		}
    }
	
	public void pushAndExecute() {
		if(historyFuture.size()!=0){
			ICommand cmd = (ICommand)this.historyFuture.remove();
			
			if(historyPass.size()==MAXIMUM_HISTORY_ITEMS){
				historyPass.remove(0);
			}
			
			historyPass.push(cmd);
			cmd.execute();
		}else{
			java.awt.Toolkit.getDefaultToolkit().beep();
		}
		if(file!=null){
			if(!saved.equals(peekLastCommand())){
				save.setEnabled(true);
			}else{
				save.setEnabled(false);
			}
		}
    }
	
	public void popAndUndo() {
		if(historyPass.size()!=0){
			ICommand cmd = (ICommand)this.historyPass.remove();
			if(historyFuture.size()==MAXIMUM_HISTORY_ITEMS){
				historyFuture.remove(0);
			}
			historyFuture.push(cmd);
			cmd.undo();
		} else {
			java.awt.Toolkit.getDefaultToolkit().beep();
		}
		if(file!=null){
			if(!saved.equals(peekLastCommand())){
				save.setEnabled(true);
			}else{
				save.setEnabled(false);
			}
		}
    }
	
	public ICommand peekLastCommand(){
		if(historyPass.size()==0)
			return new NoCommandCommand();
		return (ICommand) historyPass.peek();
	}
	
	private void cleanStatus(){
		saved = new NoCommandCommand();//
		observable = new Observable();//
		mappedListeners = new HashMap<Sheet, HashMultimap<Cell, CellChangedListener>>();//
		historyPass = new ArrayStack(MAXIMUM_HISTORY_ITEMS);//
		historyFuture = new ArrayStack(MAXIMUM_HISTORY_ITEMS);//
		methodGetter = null;
		this.setToolTipSetBinFolder("Bin Folder Not Set", null);
		formula.setText("");
		cellFormula.setText("");
	}
	
	public ViewTable(Composite parent) {
		super(parent, SWT.NONE);
		
		factory = JaxelFactory.eINSTANCE;
		
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
        this.setLayout(layout);
        
        ToolBar toolBar = addToolBarMenu();
        
        cellFormula = new Label(this, SWT.BORDER);
        FormData data = new FormData();
        data.top = new FormAttachment(toolBar,5);
        data.left = new FormAttachment(0,0);
        data.right = new FormAttachment(0,100);
        cellFormula.setLayoutData(data);
        
        formula = new Label(this, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(toolBar,5);
        data.left = new FormAttachment(cellFormula,5);
        data.right = new FormAttachment(100,0);
        formula.setLayoutData(data);
        
        cleanStatus();
        
        this.getDisplay().addFilter(SWT.KeyDown, new Listener(){
			@Override
			public void handleEvent(Event e)
			{
				if((e.stateMask & SWT.CTRL) != 0){
					if (e.keyCode == 'z'){
						ViewTable.this.popAndUndo();
					}else if(e.keyCode == 'y'){
						ViewTable.this.pushAndExecute();
					}
				}
				
				/*System.out.println("Filter-ctrl: " + SWT.CTRL);
				System.out.println("Filter-mask: " + e.stateMask);
				System.out.println("Filter-char: " + e.character);*/
			}
        });
        
	}
	
	private ToolBar addToolBarMenu(){
		
		final ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		FormData data = new FormData();
		data.left = new FormAttachment(0,0);
		data.right = new FormAttachment(100,0);
		toolBar.setLayoutData(data);
	        
		DropDownToolItem file = new DropDownToolItem("File", this, toolBar);
		file.addMenuItem("New").addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int returnCode = SWT.OK;
				
				if(!saved.equals(ViewTable.this.peekLastCommand())){
					MessageBox dialog = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("Document Not Saved");
					dialog.setMessage("The document was not saved. Do you wish to proceed?");
					returnCode = dialog.open(); 
				}
				
				if(returnCode==SWT.OK){
					
					InputDialog inputDialog = new InputDialog(getShell(), "New Sheet", "Supply the new sheet name","",null);
					inputDialog.open();
					if(inputDialog.getValue()!=null){
						
						InputDialog inputDialogRows = new InputDialog(getShell(), "New Sheet", "How many rows?", ViewTable.MAXIMUM_ROWS_DEFAULT+"", new PositiveNumberVerifier());
						inputDialogRows.open();
						
						if(inputDialogRows.getValue()!=null){
							
							InputDialog inputDialogColumns = new InputDialog(getShell(), "New Sheet", "How many columns?", ViewTable.MAXIMUM_COLUMNS_DEFAULT+"", new PositiveNumberVerifier());
							inputDialogColumns.open();
							
							if(inputDialogColumns.getValue()!=null){
					
								cleanStatus();
								
								if(tabFolder!=null){
									tabFolder.dispose();
								}
								
								tabFolder = new TabFolder(ViewTable.this, SWT.NONE);
								
								//MODEL 
								Document document = factory.createDocument();
								tabFolder.setData(document);
								
								if(viewHistogram!=null && !viewHistogram.isDisposed()){
									viewHistogram.setInput(ViewTable.this);
								}
								
								FormData data = new FormData();
								data.top = new FormAttachment(formula,5);
						        data.left = new FormAttachment(0,0);
						        data.right = new FormAttachment(100,0);
						        data.bottom = new FormAttachment(100,0);
						        tabFolder.setLayoutData(data);
						        
						        Sheet sheet = factory.createSheet();
								sheet.setName(inputDialog.getValue());
								sheet.setNumberOfRows(Integer.parseInt(inputDialogRows.getValue()));
								sheet.setNumberOfColumns(Integer.parseInt(inputDialogColumns.getValue()));
						        addSheet(sheet, false, true);
						        refreshBinPath.setEnabled(false);
							}
							
						}
					}
			        
			        ViewTable.this.layout();
			        
			        save.setEnabled(false);
			        ViewTable.this.file = null;
			        
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		save = file.addMenuItem("Save");
		save.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent event) {
		        try {
					ViewTable.this.file.save((Document)tabFolder.getData());
					ViewTable.this.saved = ViewTable.this.peekLastCommand();
					save.setEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
					MessageBox dialog = new MessageBox(getShell(), SWT.ERROR);
					dialog.setText("Not Saved");
					dialog.setMessage("It was not possible to save the file. Check if the file is opened in another program.");
					dialog.open();
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		save.setEnabled(false);
		
		saveAs = file.addMenuItem("Save As");
		saveAs.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				File workspaceDirectory = workspace.getRoot().getLocation().toFile();
				
				FileDialog fd = new FileDialog(getShell(), SWT.SAVE);
		        fd.setText("Save As");
		        fd.setFilterPath(workspaceDirectory.getPath());
		        String[] filterExt = { "*.jaxel" };
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        
		        if(selected!=null){
			        ViewTable.this.file = new FileOperations("file:///"+selected);
			        try {
						ViewTable.this.file.save((Document)tabFolder.getData());
						saved = ViewTable.this.peekLastCommand();
				        save.setEnabled(false);
					} catch (IOException e) {
						e.printStackTrace();
						MessageBox dialog = new MessageBox(getShell(), SWT.ERROR);
						dialog.setText("Not Saved");
						dialog.setMessage("It was not possible to save the file. Check if the file is opened in another program.");
						dialog.open();
					}
		        }
		        
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		saveAs.setEnabled(false);
		
		file.addMenuItem("Load").addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int returnCode = SWT.OK;
				
				if(!saved.equals(ViewTable.this.peekLastCommand())){
					MessageBox dialog = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("Document Not Saved");
					dialog.setMessage("The document was not saved. Do you wish to proceed?");
					returnCode = dialog.open(); 
				}
				
				if(returnCode==SWT.OK){
					
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					File workspaceDirectory = workspace.getRoot().getLocation().toFile();
					
					FileDialog fd = new FileDialog(getShell(), SWT.SINGLE);
			        fd.setText("Load");
			        fd.setFilterPath(workspaceDirectory.getPath());
			        String[] filterExt = { "*.jaxel" };
			        fd.setFilterExtensions(filterExt);
			        String selected = fd.open();
			        
			        if(selected!=null){
			        	
			        	cleanStatus();
			        	
				        ViewTable.this.file = new FileOperations("file:///"+selected);
				        
				        Document doc = ViewTable.this.file.load();
				        
				        if(viewHistogram!=null){
				        	viewHistogram.setInput(ViewTable.this);
				        }
				        
				        if(doc.getBinFolder()!=null){
				        	methodGetter = new DynamicMethodGetter(ViewTable.class.getClassLoader(), new File(doc.getBinFolder()));
					        methodGetter.getAllValidMethods();
					        setToolTipSetBinFolder(doc.getBinFolder(), doc.getBinFolder());
					        refreshBinPath.setEnabled(true);
				        }else{
				        	refreshBinPath.setEnabled(false);
				        }
				        
				        loadDocument(doc);
				        save.setEnabled(false);
				        saved = new NoCommandCommand();
				        
			        }
			        
				}
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
	    final DropDownToolItem document = new DropDownToolItem("Document", this, toolBar);
	    
	    addSheet = document.addMenuItem("Add Sheet");
	    addSheet.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				InputDialog inputDialog = new InputDialog(getShell(), "New Sheet", "Supply the new sheet name","",null);
				inputDialog.open();
				if(inputDialog.getValue()!=null){
					
					InputDialog inputDialogRows = new InputDialog(getShell(), "New Sheet", "How many rows?", ViewTable.MAXIMUM_ROWS_DEFAULT+"", new PositiveNumberVerifier());
					inputDialogRows.open();
					
					if(inputDialogRows.getValue()!=null){
						
						InputDialog inputDialogColumns = new InputDialog(getShell(), "New Sheet", "How many columns?", ViewTable.MAXIMUM_COLUMNS_DEFAULT+"", new PositiveNumberVerifier());
						inputDialogColumns.open();
						
						if(inputDialogColumns.getValue()!=null){
							Sheet sheet = factory.createSheet();
							sheet.setName(inputDialog.getValue());
							sheet.setNumberOfRows(Integer.parseInt(inputDialogRows.getValue()));
							sheet.setNumberOfColumns(Integer.parseInt(inputDialogColumns.getValue()));
							ViewTable.this.pushAndExecute(new AddSheetCommand(ViewTable.this, sheet));
						}
						
					}
				}
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	    addSheet.setEnabled(false);
	    
	    deleteSheet = document.addMenuItem("Delete Sheet");
	    deleteSheet.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				TabItem[] tabItems = tabFolder.getItems();
				
				/*ListSelectionDialog lsd = new ListSelectionDialog(getShell(), tabItems, new ArrayContentProvider(), new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						TabItem p = (TabItem) element;
						return p.getText();
					}
				});*/
				
				ListSelectionDialog listDialog = new ListSelectionDialog(getShell(), (Object)tabItems, ArrayContentProvider.getInstance(), new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						TabItem p = (TabItem) element;
						return p.getText();
					}
				}, "Please select the sheet you wish to delete");
				
				//ListDialog listDialog = new ListDialog(getShell());
				listDialog.setTitle("Delete Sheet");
				//listDialog.setAddCancelButton(true);
				//listDialog.setMessage("Please select the sheet you wish to delete");
				//listDialog.setContentProvider(ArrayContentProvider.getInstance());
				//listDialog.setInput(tabItems);
				/*listDialog.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						TabItem p = (TabItem) element;
						return p.getText();
					}
				});*/
				listDialog.open();
				Object[] result = (listDialog.getResult());
				if(result!=null){
					if(result.length==tabItems.length){
						MessageBox dialog = new MessageBox(getShell(), SWT.ERROR);
						dialog.setText("No Effect");
						dialog.setMessage("The document must contain at least one sheet");
						dialog.open();
					}else{
						ViewTable.this.pushAndExecute(new DeleteSheetCommand(ViewTable.this, result));
					}
				}
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	    deleteSheet.setEnabled(false);
	    
	    setBinPath = document.addMenuItem("Set Bin Path");
        setBinPath.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				File workspaceDirectory = workspace.getRoot().getLocation().toFile();
				
				DirectoryDialog fd = new DirectoryDialog(getShell(), SWT.SINGLE);
		        fd.setText("Select the bin folder");
		        fd.setFilterPath(workspaceDirectory.getPath());
		        /*String[] filterExt = { "*.jaxel" };
		        fd.setFilterExtensions(filterExt);*/
		        String selected = fd.open();
				
		        //new File(path).getParentFile().toString()+"\\bin"
		        
		        if(selected!=null){
			        pushAndExecute(new SetBinFolderCommand(ViewTable.this, selected, selected));
		        }
		        
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
        });
        setBinPath.setEnabled(false);
	    
        refreshBinPath = document.addMenuItem("Refresh Bin Path");
        refreshBinPath.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String path = ((Document)tabFolder.getData()).getBinFolder();
				if(path!=null){
					methodGetter = new DynamicMethodGetter(ViewTable.class.getClassLoader(), new File(path));
			        methodGetter.getAllValidMethods();
			        setToolTipSetBinFolder(path, path);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
        });
        refreshBinPath.setEnabled(false);
        
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(SELECTEDDOCUMENTCONTROL_ID);
	    try {
	    	for (IConfigurationElement e : config) {
	    		final Object o = e.createExecutableExtension("class");
	    		if (o instanceof IDocumentMenu) {
	    			final IDocumentMenu clazz = (IDocumentMenu) o;
	    			final String name = e.getAttribute("name"); 
	    			
	    			ISafeRunnable runnable = new ISafeRunnable() {
		    			@Override
		    			public void handleException(Throwable e) {
		    				System.out.println("Exception in client "+e.getMessage());
		    			}
		    			@Override
		    			public void run() throws Exception {
		    				MenuItem newDocumentOption = document.addMenuItem(name);
		    				
		    				newDocumentOption.addSelectionListener(new SelectionListener() {
								@Override
								public void widgetSelected(SelectionEvent e) {
				    				if(tabFolder!=null){
				    					clazz.getSelectionListener(tabFolder).widgetSelected(e);
				    				}
								}
								@Override
								public void widgetDefaultSelected(SelectionEvent e) {}
							});
		    			}
	    			};
	    			
	    			SafeRunner.run(runnable);
	    		}
	    	}
	    } catch (CoreException ex) {
	    	ex.printStackTrace();
	    }
        
	    final DropDownToolItem sheet = new DropDownToolItem("Sheet", this, toolBar);
	    
	    renameSheet = sheet.addMenuItem("Rename Sheet");
	    renameSheet.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem item = ((TabItem)tabFolder.getSelection()[0]);
				InputDialog inputDialog = new InputDialog(getShell(), "Rename Sheet "+item.getText(), "Supply the new name for the sheet","",null);
				inputDialog.open();
				
				if(inputDialog.getValue()!=null){
					ViewTable.this.pushAndExecute(new RenameSheetCommand(item,inputDialog.getValue()));
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	    renameSheet.setEnabled(false);
	    
	    
	    
	    config = Platform.getExtensionRegistry().getConfigurationElementsFor(SELECTEDSHEETCONTROL_ID);
	    System.out.println("Select sheet control plugins found: "+config.length);
	    try {
	    	for (IConfigurationElement e : config) {
	    		final Object o = e.createExecutableExtension("class");
	    		if (o instanceof ISheetMenu) {
	    			final ISheetMenu clazz = (ISheetMenu) o;
	    			final String name = e.getAttribute("name"); 
	    			
	    			ISafeRunnable runnable = new ISafeRunnable() {
		    			@Override
		    			public void handleException(Throwable e) {
		    				System.out.println("Exception in client "+e.getMessage());
		    			}
		    			@Override
		    			public void run() throws Exception {
		    				MenuItem newSheetOption = sheet.addMenuItem(name);
		    				
		    				newSheetOption.addSelectionListener(new SelectionListener() {
								@Override
								public void widgetSelected(SelectionEvent e) {
				    				if(tabFolder!=null){
				    					TabItem[] itens = tabFolder.getSelection();
				    					if(itens.length==1){
				    						Table selectedTable = (Table)itens[0].getControl();
				    						clazz.getSelectionListener(selectedTable).widgetSelected(e);
				    					}
				    				}
									
								}
								
								@Override
								public void widgetDefaultSelected(SelectionEvent e) {}
							});
		    			}
	    			};
	    			
	    			SafeRunner.run(runnable);
	    		}
	    	}
	    } catch (CoreException ex) {
	    	ex.printStackTrace();
	    }
	    
	    return toolBar;
	}
	
	
	
	 
	private void loadDocument(Document doc){
		if(tabFolder!=null)
			tabFolder.dispose();
		
		tabFolder = new TabFolder(ViewTable.this, SWT.NONE);
		
		//MODEL 
		//Document document = factory.createDocument();
		tabFolder.setData(doc);
		
		FormData data = new FormData();
		data.top = new FormAttachment(formula,5);
        data.left = new FormAttachment(0,0);
        data.right = new FormAttachment(100,0);
        data.bottom = new FormAttachment(100,0);
        tabFolder.setLayoutData(data);
		
		for(Sheet sheet: doc.getSheet_file()){
			addSheet(sheet, true, false);
		}
		ViewTable.this.layout();
	}
	
	/**
	 * 
	 * @param newSheet Must always supply name, row number and column number
	 * @param initialized
	 * @param addSheetDataToDocument
	 * @return
	 */
	public TabItem addSheet(final Sheet newSheet, final boolean initialized, final boolean addSheetDataToDocument){
		
		saveAs.setEnabled(true);
		addSheet.setEnabled(true);
		deleteSheet.setEnabled(true);
		renameSheet.setEnabled(true);
		setBinPath.setEnabled(true);
		
		final TabItem tabItem = new TabItem(tabFolder, SWT.FULL_SELECTION);
        
        //Style VIRTUAL is used to create a Table whose TableItems 
        //are to be populated by the client on an on-demand basis instead of up-front
		final Table table = new Table(tabFolder, SWT.VIRTUAL);
		tabItem.setControl(table);
		
		tabItem.setText(newSheet.getName());
		table.setData(newSheet);
		
		/*if(!initialized){
			newSheet.setNumberOfColumns(MAXIMUM_COLUMNS_DEFAULT);
			newSheet.setNumberOfRows(MAXIMUM_ROWS_DEFAULT);
		}*/
		
		//MODEL
		if(addSheetDataToDocument){
			((Document)ViewTable.this.tabFolder.getData()).getSheet_file().add(newSheet);
		}
		table.setData(newSheet);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		HashMultimap<Cell, CellChangedListener> temp = HashMultimap.create(); 
		mappedListeners.put(newSheet, temp);
		
		TableColumn label = new TableColumn(table, SWT.NONE);
		label.setText("#");
		label.setWidth(30);
		table.addListener(SWT.SetData, new Listener () {
			public void handleEvent (Event event) {
				TableItem item = (TableItem) event.item;
				int index = table.indexOf(item);
				
				//MODEL
				/*Row row = (Row) item.getData();
				if(row==null){
					row = factory.createRow();
					((Sheet)item.getParent().getData()).getRow_sheet().add(row);
					item.setData(row);
				}*/
				
				if(initialized){
					//newSheet.getRow_sheet().
					//item.setData();
					Row row = newSheet.getRows().get((Integer)index);
					if(row!=null){
						for(Integer key: row.getColumns().keySet()){
							item.setText(key, row.getColumns().get((Integer)key).getResult());
							
							String columnLabel = table.getColumns()[key].getText();
							ChangeCellCommand.setListenersToCellsRef(
										index, table, item, key, row.getColumns().get(key),
										Cell.getCells(row.getColumns().get((Integer)key).getValue()),
										"("+columnLabel+(index+1)+")", columnLabel, ViewTable.this);
						}
					}
					item.setData(row);
				}
				
				item.setText(new String[]{(index+1)+""});
				
			}
		});
		
		table.setItemCount(newSheet.getNumberOfRows());
		setNumberOfColumns(table, newSheet.getNumberOfColumns());
		
		TableEditor cellEditor = new TableEditor(table);
		cellEditor.horizontalAlignment = SWT.LEFT;
		cellEditor.grabHorizontal = true;
		
		addFormulaReportSupport(table);
		addEditingSupport(table, cellEditor);
		
		return tabItem;
	}
	
	private void addFormulaReportSupport(final Table table) {
		table.addListener (SWT.MouseDown, new Listener(){
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea ();
				Point pt = new Point (event.x, event.y);
				int index = table.getTopIndex ();
				
				while (index < table.getItemCount ()) {
					boolean visible = false;
					final TableItem item = table.getItem (index);
					for (int i=0; i<table.getColumnCount (); i++) {
						Rectangle rect = item.getBounds (i);
						if (rect.contains(pt)) {
							final int column = i;
							if(i==0){
								return;
							}
							final int line = index+1;
							cellFormula.setText(table.getColumns()[column].getText()+line);
							Row row = (Row)item.getData();
							if(row==null||row.getColumns().get((Integer)column)==null){
								formula.setText("");
							}else{
								formula.setText(row.getColumns().get((Integer)column).getValue());
							}
							return;
						}
						if (!visible && rect.intersects (clientArea)) {
							visible = true;
						}
					}
					if (!visible) return;
					index++;
				}
			}
		});
	}
	
	/**
	 * In great part taken from http://git.eclipse.org/c/platform/eclipse.platform.swt.git/tree/examples/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet124.java
	 * 
	 * @param table
	 * @param editor
	 */
	private void addEditingSupport(final Table table, final TableEditor editor) {
		table.addListener (SWT.MouseDoubleClick, new Listener () {
			public void handleEvent (Event event) {
				Rectangle clientArea = table.getClientArea ();
				Point pt = new Point (event.x, event.y);
				int index = table.getTopIndex ();
				
				while (index < table.getItemCount ()) {
					boolean visible = false;
					final TableItem item = table.getItem (index);
					for (int i=0; i<table.getColumnCount (); i++) {
						Rectangle rect = item.getBounds (i);
						if (rect.contains(pt)) {
							final int column = i;
							if(i==0){
								return;
							}
							final Text text = new Text (table, SWT.NONE);
							final int line = index;
							Listener textListener = new Listener () {
								public void handleEvent (final Event e) {
									switch (e.type) {
										case SWT.FocusOut:
											ViewTable.this.pushAndExecute(
													new ChangeCellCommand(text.getText(), line, column, (Sheet)table.getData(), ViewTable.this)
													);
											text.dispose ();
											break;
										case SWT.Traverse:
											switch (e.detail) {
												case SWT.TRAVERSE_RETURN:
													ViewTable.this.pushAndExecute(
															new ChangeCellCommand(text.getText(), line, column, (Sheet)table.getData(), ViewTable.this)
															);
													//FALL THROUGH
												case SWT.TRAVERSE_ESCAPE:
													text.dispose ();
													e.doit = false;
											}
											break;
									}
								}
							};
							text.addListener (SWT.FocusOut, textListener);
							text.addListener (SWT.Traverse, textListener);
							editor.setEditor (text, item, i);
							
							//CellColumn cellElement = ((Row)item.getData()).getColumns().get((Integer)i);
							/*if(cellElement==null){
								text.setText(item.getText(i));
							}else{
								text.setText(((Row)item.getData()).getColumns().get((Integer)i).getValue());
							}*/
							
							Row row = (Row)item.getData();
							if(row==null || row.getColumns().get((Integer)i)==null){
								text.setText("");
							}else{
								text.setText(row.getColumns().get((Integer)i).getValue());
							}
							
							text.selectAll ();
							text.setFocus ();
							return;
						}
						if (!visible && rect.intersects (clientArea)) {
							visible = true;
						}
					}
					if (!visible) return;
					index++;
				}
			}
		});
	}
	
	
	
	
	
	/**
	 * 
	 * @param table
	 * @param numberOfColumns
	 */
	private void setNumberOfColumns(Table table, int numberOfColumns){
		numberOfColumns++;
		int index = numberOfColumns-table.getColumnCount();
		if(index>0){
			while(index!=0){
				String lastColumnText = "";
				if(table.getColumnCount()>1){
					int lastIndex = table.getColumnCount()-1;
					lastColumnText=table.getColumn(lastIndex).getText();
				}
				TableColumn label = new TableColumn(table, SWT.CENTER);
				label.setText(Cell.getNextLabel(lastColumnText));
				label.setWidth(70);
				index--;
			}
		}else if(index<0){
			while(index!=0){
				table.getColumns()[table.getColumnCount()-1].dispose();
				index++;
			}
		}
		table.redraw();
	}
	
}
