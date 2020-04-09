package org.openxava.xavaprojects.model;

import java.util.*;
import javax.persistence.*;
import org.openxava.jpa.*;

/**
 * TMP ME QUEDÉ POR: YA ESTÁ TODO HECHO. FALTA REVISAR CÓDIGO, PASAR SUITE, PROBAR MIGRACIÓN EN ORGANIZACION E INSTALAR
 * @author Javier Paniza
 */

@Entity
public class IssueStatus extends Iconable {
			
	private boolean useAsDefaultValue;
	
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

	public boolean isUseAsDefaultValue() {
		return useAsDefaultValue;
	}

	public void setUseAsDefaultValue(boolean useAsDefaultValue) {
		if (this.useAsDefaultValue == useAsDefaultValue) return;
		unsetUseAsDefaultValueForAll();
		this.useAsDefaultValue = useAsDefaultValue;
	}

}
