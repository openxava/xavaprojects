package org.openxava.xavaprojects.model;

import javax.persistence.*;

import lombok.*;

/**
 * @author Javier Paniza
 */

@Entity @Getter @Setter
public class IssueStatus extends IconableWithUseAsDefaultValueForMyCalendar {
			
	boolean useAsDefaultValue;
		
	/* tmr
	public static IssueStatus findTheDefaultOne() {
		List<IssueStatus> status = XPersistence.getManager()
			.createQuery("from IssueStatus where useAsDefaultValue = true")
			.getResultList();
		if (status.size() == 1) return status.get(0);
		return null;
	}
			
	private void unsetUseAsDefaultValueForAll() {
		XPersistence.getManager().createQuery("update IssueStatus set useAsDefaultValue = false").executeUpdate();
	}

	public void setUseAsDefaultValue(boolean useAsDefaultValue) {
		if (this.useAsDefaultValue == useAsDefaultValue) return;
		unsetUseAsDefaultValueForAll();
		this.useAsDefaultValue = useAsDefaultValue;
	}
	*/
	
	// tmr ini
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
	// tmr fin

}
