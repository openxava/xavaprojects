package org.openxava.xavaprojects.actions;

import org.openxava.actions.*;

import lombok.*;

/**
 * tmr
 * 
 * @author Javier Paniza
 */
public class InitOnListAction extends InitListAction {
	
	@Getter @Setter
	String module;
	
	protected String getQualifiedActionIfAvailable(String simpleName) {
		if (getManager().getModuleName().equals(module)) return null;
		return super.getQualifiedActionIfAvailable(simpleName);
	}

}
