package org.openxava.xavaprojects.actions;

import org.openxava.actions.*;
import org.quartz.*;
import org.quartz.impl.*;

/**
 * tmr Para hacer pruebas, quitarla
 * @author Javier Paniza
 *
 */

public class PlanAction extends BaseAction {
	
	private static Scheduler scheduler;
	
	static {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void execute() throws Exception {
		// TMR ME QUEDÉ POR AQUÍ: ESTO ME ACABO DE FUNCIONAR
		
		System.out.println("[PlanAction.execute] Planeando..."); // tmr


        JobDetail job = JobBuilder.newJob(ScheduledTask.class)
                .withIdentity("emailJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("emailTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
	}

}
