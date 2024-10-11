package org.openxava.xavaprojects.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.jpa.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity @Getter @Setter
public class Worker extends Nameable {
		
	/* It could be in this way with XavaPro
	@DescriptionsList
	@ManyToOne(fetch = FetchType.LAZY)
	User user;  
	*/
	
	@Column(length=30)
	String userName; // tmr En schema-evolution.sql
	
	@Column(length=60) @Email 
	String email; // tmr En schema-evolution.sql
	
	public static Worker findById(String id) { // tmr 
		return XPersistence.getManager().find(Worker.class, id);
	}
	
}
