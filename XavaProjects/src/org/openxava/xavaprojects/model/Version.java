package org.openxava.xavaprojects.model;

import java.util.*;
import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.jpa.*;
import org.openxava.model.Identifiable;

/**
 * 
 * @author Javier Paniza
 */

@Entity
@Tab(defaultOrder="${name} desc") 
public class Version extends Identifiable {
	
	public static List<Version> findByName(String name) { 
		return XPersistence.getManager()
			.createQuery("from Version v where v.name = :name")
			.setParameter("name", name)
			.getResultList();
	}

	@DescriptionsList
	@ManyToOne(fetch=FetchType.LAZY)
	private Project project;
	
	@Column(length=20)
	private String name; 
	
	@ListProperties("status.icon, title, type.icon, createdBy")
	@OneToMany(mappedBy="version")
	@OrderColumn
	private List<Issue> issues;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
