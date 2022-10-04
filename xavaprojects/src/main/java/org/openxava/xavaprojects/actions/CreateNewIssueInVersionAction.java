package org.openxava.xavaprojects.actions;

import org.openxava.actions.*;

/**
 * 
 * @author Javier Paniza
 */
public class CreateNewIssueInVersionAction extends CreateNewElementInCollectionAction {
	
	
	public void execute() throws Exception {
		String projectId = getView().getValueString("project.id"); 
		super.execute();
		getCollectionElementView().setValue("project.id", projectId);
		getCollectionElementView().setEditable("project", false);
	}

}
