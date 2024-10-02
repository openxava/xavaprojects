package org.openxava.xavaprojects.model;

import javax.persistence.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity @Getter @Setter
public class IssueType extends IconableWithUseAsDefaultValueForMyCalendar {
	
	public static IssueType findTheDefaultOneForMyCalendar() {
		return (IssueType) findTheDefaultOne("IssueType", "useAsDefaultValueForMyCalendar");
	}
	
}
