package org.openxava.xavaprojects.actions;

import org.openxava.actions.*;

/**
 *  tmr ¿Incluir en OpenXava? 
 * 
 * @author javie
 */
public class SaveReturningToListAction extends SaveAction {
	
	public String getNextMode() {
		return LIST;
	}

}
