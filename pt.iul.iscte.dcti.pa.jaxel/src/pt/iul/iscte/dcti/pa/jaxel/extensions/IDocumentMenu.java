package pt.iul.iscte.dcti.pa.jaxel.extensions;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabFolder;

public interface IDocumentMenu {
	
	SelectionListener getSelectionListener(TabFolder tabFolder);
	
}
