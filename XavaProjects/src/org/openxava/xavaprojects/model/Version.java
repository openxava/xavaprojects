package org.openxava.xavaprojects.model;

import java.util.*;
import javax.persistence.*;
import org.openxava.model.Identifiable;

/**
 * 
 * @author Javier Paniza
 */

@Entity
public class Version extends Identifiable {
	
	@Column(length=20)
	private String name;
	
	@OneToMany(mappedBy="version")
	@OrderColumn
	private List<Issue> issues;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addIssue(Issue issue) {
		if (issues == null) issues = new ArrayList<>();
		issues.add(issue);
	}
	
	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
