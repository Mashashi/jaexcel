package pt.iul.iscte.dcti.pa.jaxel.command;

/**
 * Just for the initialization of the saved status tracking variable 
 * 
 * @author Rafael
 */
public class NoCommandCommand implements ICommand{

	public NoCommandCommand() {}
	
	@Override
	public void execute() {}

	@Override
	public void undo() {}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof NoCommandCommand)?true:super.equals(obj);
	}
}
