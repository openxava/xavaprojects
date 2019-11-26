package org.openxava.xavaprojects.model;

import java.math.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.*;
import org.openxava.web.editors.*;
import org.openxava.xavaprojects.calculators.*;

/**
 * 
 * @author Javier Paniza
 */

@Entity
public class Issue extends Identifiable {

	@Column(length=100) @Required
	private String title;
	
	@DescriptionsList
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private IssueType type;
	
	@Stereotype("SIMPLE_HTML_TEXT") @Column(columnDefinition="MEDIUMTEXT")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList
	@DefaultValueCalculator(DefaultProjectCalculator.class)
	private Project project; 
	
	@Column(length=30) @ReadOnly
	@DefaultValueCalculator(CurrentUserCalculator.class)
	private String createdBy;
	
	@ReadOnly 
	@DefaultValueCalculator(CurrentLocalDateCalculator.class) 
	private LocalDate createdOn;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList(order="${level} desc")
	@DefaultValueCalculator(value=IntegerCalculator.class, 
		properties = @PropertyValue(name="value", value="5") )
	private Priority priority; 
		
	@DescriptionsList(condition="project.id = ?", depends="this.project", order="${name} desc") 
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	private Version version;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@DescriptionsList(descriptionProperties="worker.name, period.name")
	private Plan assignedTo; 
	
	private boolean closed;
	
	// tmp ini
	// tmp ME QUEDÉ POR AQUÍ: FALTA AÑADIR REFERENCIA A Customer Y PROBAR
	@Max(99999)
	private int minutes;
	
	@Calculation("minutes / 60")
	@Column(length=6, scale=2)
	private BigDecimal hours;
	// tmp fin
	
	@Stereotype("FILES") @Column(length=32)
	private String attachments;
	
	@Stereotype("IMAGES_GALLERY") @Column(length=32)
	private String screenshots;

	@Stereotype("DISCUSSION")
	@Column(length=32)
	private String discussion;
	
	@PreRemove
	private void removeDiscussion() {
	    DiscussionComment.removeForDiscussion(discussion);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IssueType getType() {
		return type;
	}

	public void setType(IssueType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}

	public String getDiscussion() {
		return discussion;
	}

	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
		if (this.version != null) this.version.addIssue(this);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Plan getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Plan assignedTo) {
		this.assignedTo = assignedTo;
		if (this.assignedTo != null) this.assignedTo.addIssue(this);
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

}
