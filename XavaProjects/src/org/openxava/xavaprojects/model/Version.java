package org.openxava.xavaprojects.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.openxava.model.Identifiable;

/**
 * 
 * @author Javier Paniza
 */

@Entity
public class Version extends Identifiable {
	
	@Column(length=20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
