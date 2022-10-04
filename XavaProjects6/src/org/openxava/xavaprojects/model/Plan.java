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
	
	@ListProperties("status.icon, title, type.icon, project.name, version.name") 
	@OneToMany(mappedBy="assignedTo")
	@OrderColumn(name="Plan_issues_ORDER")
	private List<Issue> issues;

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
	
	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
