package org.openxava.xavaprojects.model;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * 
 * @author Javier Paniza
 */

@MappedSuperclass
public class Iconable extends Nameable {

	@Column(length=40) @Stereotype("ICON")
	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
