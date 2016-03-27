package pt.iul.iscte.dcti.pa.jaxel.observer;

import java.util.LinkedList;


public class Observable implements IObservable{
	
	private final LinkedList<IEventListener> eventListeners;
	
	public Observable() {
		eventListeners = new LinkedList<IEventListener>();
	}
	
	@Override
	public void newEvent(EEventType eventType, Object[] extraData){
		synchronized (eventListeners) {
			final EventDetails details = new EventDetails(eventType, extraData);
			for(IEventListener event :eventListeners){
				event.handleEvent(details);
			}
		}
	}
	@Override
	public boolean addListener(IEventListener eventListener){
		synchronized (eventListeners) {
			return eventListeners.add(eventListener);
		}
	}

	@Override
	public boolean removeListener(IEventListener eventListener) {
		synchronized (eventListeners) {
			return eventListeners.remove(eventListener);
		}		
	}
	
}
