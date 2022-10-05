package org.openxava.xavaprojects.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity @Getter @Setter
@Tab(defaultOrder="${level} desc")
public class Priority {
	
	@Id @Max(9)
	int level;
	
	@Column(length=40) @Required
	String description;

}
