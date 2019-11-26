package org.openxava.xavaprojects.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

/**
 * tmp
 * 
 * @author Javier Paniza
 */

@MappedSuperclass
public class Nameable extends Identifiable {

	@Column(length=40) @Required
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
