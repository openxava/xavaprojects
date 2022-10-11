package org.openxava.xavaprojects.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@MappedSuperclass @Getter @Setter
public class Iconable extends Nameable {

	@Column(length=40) @Stereotype("ICON")
	private String icon;
	
}
