package org.openxava.xavaprojects.jobs;

import java.time.format.*;

import org.openxava.jpa.*;
import org.openxava.util.*;
import org.openxava.xavaprojects.model.*;
import org.quartz.*;

/**
 * tmr
 * 
 * @author Javier Paniza
 */
public class PlannedIssueReminderJob implements Job {
    
    public void execute(JobExecutionContext context) {
    	try {
    		String issueId = context.getJobDetail().getJobDataMap().getString("issue.id");
    		Issue issue = Issue.findById(issueId);
    		if (issue == null) return;
    		Plan plan = issue.getAssignedTo();
    		if (plan == null) return;
    		Worker worker = plan.getWorker();
    		if (worker == null) return;
    		String workerEmail = worker.getEmail();
    		if (Is.emptyString(workerEmail)) return;
    		if (issue.getPlannedFor() == null) return;
    		
    		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    		String formattedDate = issue.getPlannedFor().format(formatter);
    		
    		String subject = XavaResources.getString("planned_issue_reminder_subject", issue.getTitle(), formattedDate);
    		String content = XavaResources.getString("planned_issue_reminder_content", issue.getTitle(), formattedDate);
    		
    		System.out.println("[PlannedIssueReminderJob.execute] Enviando mensaje a " + workerEmail); // tmr
    		Emails.send(workerEmail, subject, content);

    	}
    	catch (Exception ex) {
    		ex.printStackTrace(); // tmr
    	}
    	finally {
    		XPersistence.commit();
    	}    	
    }
    
}