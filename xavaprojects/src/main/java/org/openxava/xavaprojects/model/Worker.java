package org.openxava.xavaprojects.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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
	
}
