package org.openxava.xavaprojects.calculators;

import org.openxava.calculators.*;
import org.openxava.xavaprojects.model.*;

/**
 * 
 * @author Javier Paniza
 */
public class DefaultProjectCalculator implements ICalculator {

	
	public Object calculate() throws Exception {
		Project unique = Project.findUnique();
		return unique == null?null:unique.getId();
	}
	
	

}
