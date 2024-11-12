package org.openxava.xavaprojects.jobs;

import org.quartz.*;

/**
 * tmr
 * 
 * @author Javier Paniza
 */
public class PlannedIssueReminderJob implements Job {
    
    public void execute(JobExecutionContext context) {
    	System.out.println("[PlanAction.ScheduledTask.execute] DOING AT A SPECIFIC DATE/TIME"); // tmr
    	
    }
    
}