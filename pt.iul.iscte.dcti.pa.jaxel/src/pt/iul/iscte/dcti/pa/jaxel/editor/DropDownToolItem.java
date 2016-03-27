package pt.iul.iscte.dcti.pa.jaxel.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class DropDownToolItem extends SelectionAdapter{
    
	private final Menu dropMenu;
	private final ToolItem toolItem;
	
	public DropDownToolItem(String name, Composite containter, ToolBar toolBar){
		dropMenu = new Menu(containter);
		toolItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		toolItem.setText(name);
		toolItem.addSelectionListener(this);
	}
	
	public MenuItem addMenuItem(String name){
		MenuItem item = new MenuItem(dropMenu, SWT.PUSH);
		item.setText(name);
		return item;
	}
	
    @Override
    public void widgetSelected(SelectionEvent e) {
        if (e.detail == SWT.ARROW ) {
            // Position the menu below and vertically aligned with the the drop down tool button.
            final ToolItem toolItem = (ToolItem) e.widget;
            final ToolBar  toolBar = toolItem.getParent();
            Point clicked = new Point(e.x, e.y);
            Point point = toolBar.toDisplay(clicked);
            dropMenu.setLocation(point.x, point.y);
            dropMenu.setVisible(true);
        }
    }
}
