package org.openxava.xavaprojects.model;

import javax.persistence.*;

import lombok.*;

/**
 * @author Javier Paniza
 */

@Entity @Getter @Setter
public class IssueStatus extends IconableWithUseAsDefaultValueForMyCalendar {
			
	boolean useAsDefaultValue;
		
	public static IssueStatus findTheDefaultOne() {
		return (IssueStatus) findTheDefaultOne("IssueStatus", "useAsDefaultValue");
	}
	
	public static IssueStatus findTheDefaultOneForMyCalendar() {
		return (IssueStatus) findTheDefaultOne("IssueStatus", "useAsDefaultValueForMyCalendar");
	}	
	
	public void setUseAsDefaultValue(boolean useAsDefaultValue) {
		if (this.useAsDefaultValue == useAsDefaultValue) return;
		unsetUseAsDefaultValueForAll("useAsDefaultValue");
		this.useAsDefaultValue = useAsDefaultValue;
	}		

}
