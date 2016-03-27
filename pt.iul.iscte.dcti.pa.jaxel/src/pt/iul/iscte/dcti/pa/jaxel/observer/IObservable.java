package pt.iul.iscte.dcti.pa.jaxel.observer;


public interface IObservable {
	
	public void newEvent(EEventType eventType, Object[] extraData);
	
	public boolean addListener(IEventListener eventListener);
	
	public boolean removeListener(IEventListener eventListener);
	
}
