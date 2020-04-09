package org.openxava.xavaprojects.calculators;

import org.openxava.calculators.*;
import org.openxava.xavaprojects.model.*;

public class DefaultIssueStatusCalculator implements ICalculator {

	
	public Object calculate() throws Exception {
		IssueStatus theDefaultOne = IssueStatus.findTheDefaultOne();
		Object result = theDefaultOne == null?null:theDefaultOne.getId();
		System.out.println("[DefaultIssueStatusCalculator.calculate] result=" + result); // tmp
		return result;
	}
	
}
