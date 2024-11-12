package org.openxava.xavaprojects.actions;

import java.time.*;
import java.util.*;

import org.openxava.actions.*;
import org.openxava.xavaprojects.jobs.*;
import org.quartz.*;
import org.quartz.impl.*;

/**
 * https://github.com/quartz-scheduler/quartz/blob/main/quartz/src/main/resources/org/quartz/impl/jdbcjobstore/tables_mysql.sql
 * 
 * tmr Para hacer pruebas, quitarla
 * @author Javier Paniza
 *
 */

public class PlanAction extends BaseAction {
	

	public void execute() throws Exception {

		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		// Define la fecha (sin hora) usando LocalDate
		LocalDate localDate = LocalDate.of(2024, 11, 12); // 15 de noviembre de 2024

		// Convierte LocalDate a LocalDateTime (a las 00:00 horas por defecto)
		// tmr LocalDateTime localDateTime = localDate.atStartOfDay(); 
		LocalDateTime localDateTime = localDate.atTime(20, 15);

		// Convierte LocalDateTime a Date (usando ZoneId.systemDefault())
		
		Date specificDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("title", "El título");
		jobDataMap.put("worker", "The worker");
		jobDataMap.put("issueURL", "The issueURL");

        JobDetail job = JobBuilder.newJob(PlannedIssueReminderJob.class)
            .withIdentity("emailJob", "group1")
            .usingJobData(jobDataMap)
            .build();

		Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("emailTrigger", "group1")
            .startAt(specificDate)  // Define la fecha de ejecución
            .build();

        scheduler.scheduleJob(job, trigger);
		
	}

}
