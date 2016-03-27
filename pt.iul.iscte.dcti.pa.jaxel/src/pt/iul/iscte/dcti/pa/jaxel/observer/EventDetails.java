package pt.iul.iscte.dcti.pa.jaxel.observer;

public class EventDetails{
	public final EEventType eventType;
	public final Object[] extraData;
	public EventDetails(EEventType eventType, Object[] extraData) {
		this.eventType = eventType;
		this.extraData = extraData;
	}
}