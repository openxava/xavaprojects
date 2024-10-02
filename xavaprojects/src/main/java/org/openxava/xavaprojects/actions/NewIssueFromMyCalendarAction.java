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
	
	private boolean goList = false;
	
	public void execute() throws Exception {
		// TMR ME QUEDÉ POR AQUÍ: YA FUNCIONA. DEBERÍA EMPEZAR CON LOS TESTS
		if ("true".equals(getRequest().getParameter("firstRequest"))) {
			goList = true;
			return;
		}
		super.execute();
		calculatePlanDefaultValue();	
		calculateStatusDefaultValue();
		calculateTypeDefaultValue();
	}

	public String getNextMode() {
		return goList?IChangeModeAction.LIST:IChangeModeAction.DETAIL;
	}

	private void calculatePlanDefaultValue() {
		// LocalDate plannedFor = (LocalDate) getView().getValue("plannedFor"); // tmr Waiting to bug be fixed		
		LocalDate plannedFor = parseDate(getView().getValueString("plannedFor"));
		if (plannedFor == null) {
			plannedFor = LocalDate.now();
			getView().setValue("plannedFor", plannedFor);
		}
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
		getView().setValue("assignedTo.id", plan.getId());
	}
	
	private void calculateStatusDefaultValue() {
		getView().setValue("status.id", IssueStatus.findTheDefaultOneForMyCalendar().getId());
	}
	
	private void calculateTypeDefaultValue() {
		getView().setValue("type.id", IssueType.findTheDefaultOneForMyCalendar().getId());
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
