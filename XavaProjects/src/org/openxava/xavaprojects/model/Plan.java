package org.openxava.xavaprojects.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity
@Tab(defaultOrder="${period.name} desc, ${worker.name} asc") 
public class Plan extends Identifiable {
	
	@DescriptionsList
	@ManyToOne(optional=false)
	private Worker worker;
	
	@DescriptionsList
	@ManyToOne(optional=false)
	private Period period;
	
	@ListProperties("title, description, project.name, version.name, closed")
	@OneToMany(mappedBy="assignedTo")
	@OrderColumn(name="Plan_issues_ORDER")
	private List<Issue> issues;
	
	@PostLoad
	private void refineIssues() { // Until we close https://openxava.org/XavaProjects/o/OpenXava/m/Issue?detail=ff8080816ef62a87016f10058c7a001c
		if (issues == null) return;
		while (issues.remove(null));
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
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

}
