package org.openxava.xavaprojects.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity
@Tab(defaultOrder="${level} desc")
public class Priority {
	
	@Id @Max(9)
	private int level;
	
	@Column(length=40) @Required
	private String description;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
