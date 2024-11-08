package org.openxava.xavaprojects.actions;

import org.quartz.*;

// tmr ¿En este paquete? ¿Este nombre?
public class ScheduledTask implements Job {
    
    public void execute(JobExecutionContext context) {
    	System.out.println("[PlanAction.ScheduledTask.execute] DOING..."); // tmr
    }
}