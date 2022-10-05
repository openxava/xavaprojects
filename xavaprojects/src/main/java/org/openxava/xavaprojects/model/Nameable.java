package org.openxava.xavaprojects.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@MappedSuperclass @Getter @Setter
public class Nameable extends Identifiable {

	@Column(length=40) @Required
	String name;
	
}
