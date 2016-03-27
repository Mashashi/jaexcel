package pt.iul.iscte.dcti.pa.jaxel;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;
import pt.iul.iscte.dcti.pa.jaxel.histogram.ViewHistogram;

public class HistogramView extends ViewPart{
	
	private ViewHistogram histogramView;
	
	@Override
	public void createPartControl(Composite parent) {
		histogramView = new ViewHistogram(parent);
		ViewTable.viewHistogram = histogramView;
		try {
			TableView view = (TableView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView( "pt.iul.iscte.dcti.pa.jaxel.view1");
			if(view!=null && view.table.tabFolder!=null){
				histogramView.setInput(view.table);
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
		histogramView.setFocus();
	}

}