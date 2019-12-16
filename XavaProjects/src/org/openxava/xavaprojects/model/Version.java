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
	
	@ListProperties("title, description, createdBy, closed")
	@OneToMany(mappedBy="version")
	@OrderColumn
	private List<Issue> issues;
	
	@PostLoad
	private void refineIssues() { // Until we close https://openxava.org/XavaProjects/o/OpenXava/m/Issue?detail=ff8080816ef62a87016f10058c7a001c
		if (issues == null) return;
		while (issues.remove(null));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void addIssue(Issue issue) { // Until we close https://openxava.org/XavaProjects/o/OpenXava/m/Issue?detail=ff8080816ef62a87016f10058c7a001c
		if (issues == null) issues = new ArrayList<>();
		if (!issues.contains(issue)) issues.add(issue);
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
