package org.openxava.xavaprojects.calculators;

import org.openxava.calculators.*;
import org.openxava.xavaprojects.model.*;

public class DefaultIssueStatusCalculator implements ICalculator {

	
	public Object calculate() throws Exception {
		IssueStatus theDefaultOne = IssueStatus.findTheDefaultOne();
		return theDefaultOne == null?null:theDefaultOne.getId();
	}
	
}
