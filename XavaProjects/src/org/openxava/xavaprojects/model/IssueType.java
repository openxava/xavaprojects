package org.openxava.xavaprojects.model;

import javax.persistence.*;

import org.openxava.model.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity
public class IssueType extends Identifiable {
	
	@Column(length=40)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
