package org.openxava.xavaprojects.model;

import java.math.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;
import org.openxava.model.*;
import org.openxava.web.editors.*;
import org.openxava.xavaprojects.calculators.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity @Getter @Setter
@Tab(properties="title, type.name, description, project.name, version.name, createdBy, createdOn, status.name")
@Tab(name="MyCalendar", editors="Calendar", 
	properties="title", 
	baseCondition = "${assignedTo.worker.userName} = ?", 
	filter=org.openxava.filters.UserFilter.class)
public class Issue extends Identifiable {

	@Column(length=100) @Required
	String title;
	
	@DescriptionsList
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	IssueType type;
		
	@Stereotype("SIMPLE_HTML_TEXT") @Column(columnDefinition="MEDIUMTEXT")
	String description;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList
	@DefaultValueCalculator(DefaultProjectCalculator.class)
	Project project; 
	
	@Column(length=30) @ReadOnly
	@DefaultValueCalculator(CurrentUserCalculator.class)
	String createdBy;
	
	LocalDate plannedFor; 	
	
	@ReadOnly 
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) 
	LocalDate createdOn;
		
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList(order="${level} desc")
	@DefaultValueCalculator(value=IntegerCalculator.class, 
		properties = @PropertyValue(name="value", value="5") )
	Priority priority; 
		
	@DescriptionsList(condition="project.id = ?", depends="this.project", order="${name} desc") 
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	Version version;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList(descriptionProperties="worker.name, period.name")
	Plan assignedTo;
	
	@DescriptionsList
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@DefaultValueCalculator(DefaultIssueStatusCalculator.class) 
	IssueStatus status; 
	
	@DescriptionsList
	@ManyToOne(fetch=FetchType.LAZY)
	Customer customer; 

	@Max(99999)
	int minutes; 
	
	@ReadOnly
	@Calculation("minutes / 60")
	@Column(length=6, scale=2)
	BigDecimal hours; 
	
	@Stereotype("FILES") @Column(length=32)
	String attachments;
	
	@Stereotype("DISCUSSION")
	@Column(length=32)
	private String discussion;
	
	@PreRemove
	void removeDiscussion() {
	    DiscussionComment.removeForDiscussion(discussion);
	}

	public static Issue findByTitle(String title) { 
		TypedQuery<Issue> query = XPersistence.getManager().createQuery(
			"from Issue i where i.title = :title", Issue.class);
		query.setParameter("title", title);
		return query.getSingleResult();
	}

}
