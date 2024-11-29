package org.openxava.xavaprojects.actions;

import org.openxava.actions.*;

/**
 * 
 * @author Javier Paniza
 */
public class SaveReturningToListAction extends SaveAction {
	
	public String getNextMode() {
		return LIST;
	}

}
