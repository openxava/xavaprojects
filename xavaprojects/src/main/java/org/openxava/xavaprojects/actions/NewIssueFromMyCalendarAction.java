package org.openxava.xavaprojects.actions;

import java.text.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.formatters.*;
import org.openxava.jpa.*;
import org.openxava.util.*;
import org.openxava.xavaprojects.model.*;

/**
 * tmr
 * 
 * @author Javier Paniza
 */
public class NewIssueFromMyCalendarAction extends NewAction {
	
	public void execute() throws Exception {
		super.execute();
		calculatePlanDefaultValue();
	}

	private void calculatePlanDefaultValue() {
		// TMR ME QUEDÉ POR AQUÍ. YA NO FALLA, FALTA PROBARLO CON VARIOS CASOS, PARA VER SI FUNCIONA BIEN
		// LocalDate plannedFor = (LocalDate) getView().getValue("plannedFor"); // tmr Waiting to bug be fixed		
		LocalDate plannedFor = parseDate(getView().getValueString("plannedFor"));
		Query query = XPersistence.getManager().createQuery(
			"from Plan p where p.worker.userName = :userName and :plannedFor between p.period.startDate and p.period.endDate");
		query.setParameter("plannedFor", plannedFor);
		query.setParameter("userName", Users.getCurrent());
		List<Plan> plans = query.getResultList(); 
		if (plans.isEmpty()) {
			addWarning("There is no plan for " + Users.getCurrent() + " for the date " + plannedFor);
			addWarning("You should create it and assign to this issue");
			return;
		}
		Plan plan = plans.get(0);
		getView().setValue("plan.id", plan.getId());
	}
	
	private LocalDate parseDate(Object dateString) {
		// tmr return LocalDate.parse((String) dateString, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locales.getCurrent()));
		String date = ((String) dateString).split(" ")[0];
		try {
			return (LocalDate) new LocalDateFormatter().parse(getRequest(), date);
		} 
		catch (ParseException ex) {			
			ex.printStackTrace(); // tmr
			return null;
		}
	}

}
