package pt.iul.iscte.dcti.pa.jaxel.histogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import pt.iul.iscte.dcti.pa.jaxel.CellColumn;
import pt.iul.iscte.dcti.pa.jaxel.Document;
import pt.iul.iscte.dcti.pa.jaxel.Row;
import pt.iul.iscte.dcti.pa.jaxel.Sheet;
import pt.iul.iscte.dcti.pa.jaxel.editor.ViewTable;
import pt.iul.iscte.dcti.pa.jaxel.impl.CellColumnImpl;

public class ViewHistogram extends Composite {

	private Canvas chart;
	
	public ViewHistogram(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
	}
	
	
	public void setInput(final ViewTable mytable) {
		if(chart != null){
			chart.dispose();
		}
		chart = new Canvas(this, SWT.BORDER);
		final Document document = ((Document)mytable.tabFolder.getData());
		chart.addPaintListener(new PaintListener() {	
			@Override
			public void paintControl(PaintEvent e) {
				if(mytable.tabFolder!=null){
					Map<String, Integer> count = new HashMap<String, Integer>();
					for(Sheet s: document.getSheet_file()){
					for(Row r : s.getRows().values()) {
						for(CellColumn el : r.getColumns().values())
							if(!count.containsKey(el.getValue())){
								count.put(el.getValue(), 1);
							}else{
								int i = count.get(el.getValue());
								count.put(el.getValue(), i + 1);
							}
					}
					}
					e.gc.setForeground(new Color(null, 0, 0, 0));
					e.gc.setBackground(new Color(null, 255, 255, 255));
					e.gc.setFont(new Font(null, new FontData("Arial", 14, SWT.NONE)));
					
					int x = 10;
					for(Entry<String, Integer> entry : count.entrySet()) {
						e.gc.drawText(entry.getKey(), x, 0);
						e.gc.drawRectangle(x, 30, 40, entry.getValue() * 20);
						e.gc.fillRectangle(x, 30, 40, entry.getValue() * 20);
						x += 50;
					}
				}
			}
		});
		
		document.eAdapters().add(new EContentAdapter(){
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if((notification.getNotifier() instanceof CellColumnImpl) && notification.getEventType()==Notification.SET){
					
					String attributeChanged = ((EAttributeImpl)notification.getFeature()).getName();
					if(attributeChanged.equals("result")){
						//System.out.println("Changed to "+notification.getNewStringValue()+" from "+notification.getOldStringValue());
						if(!chart.isDisposed()){
							chart.redraw();	
							layout();
						}
					}
					
				}
			}
		});
		
		layout();
		
	}
}