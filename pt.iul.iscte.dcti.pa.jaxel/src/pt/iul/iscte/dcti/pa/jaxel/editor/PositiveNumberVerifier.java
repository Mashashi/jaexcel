package pt.iul.iscte.dcti.pa.jaxel.editor;

import org.eclipse.jface.dialogs.IInputValidator;

public class PositiveNumberVerifier implements IInputValidator{

	@Override
	public String isValid(String newText) {
		try{
			int i = Integer.parseInt(newText);
			if(i>0){
				return null;
			}
		}catch(Exception e){}
		return "The supplied number must be a positive integer";
	}

}
