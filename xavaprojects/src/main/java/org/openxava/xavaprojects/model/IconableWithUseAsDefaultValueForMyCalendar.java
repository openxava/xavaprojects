package org.openxava.xavaprojects.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.jpa.*;

import lombok.*;

/**
 * tmr
 * @author Javier Paniza
 */

@MappedSuperclass @Getter @Setter
public class IconableWithUseAsDefaultValueForMyCalendar extends Iconable {
			
	boolean useAsDefaultValueForMyCalendar; // tmr i18n, en schema-evolution.sql
			
	protected static Object findTheDefaultOne(String entity, String property) {
		List status = XPersistence.getManager()
			.createQuery("from " + entity +  " where " + property + " = true")
			.getResultList();
		if (status.size() == 1) return status.get(0);
		return null;
	}
			
	protected void unsetUseAsDefaultValueForAll(String property) {
		XPersistence.getManager().createQuery("update " + getClass().getSimpleName() + " set " + property + " = false").executeUpdate();
	}
	
	public void setUseAsDefaultValueForMyCalendar(boolean useAsDefaultValueForMyCalendar) {
		if (this.useAsDefaultValueForMyCalendar == useAsDefaultValueForMyCalendar) return;
		unsetUseAsDefaultValueForAll("useAsDefaultValueForMyCalendar");
		this.useAsDefaultValueForMyCalendar = useAsDefaultValueForMyCalendar;
	}

}
