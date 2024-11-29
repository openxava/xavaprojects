package org.openxava.xavaprojects.tests;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openqa.selenium.*;
import org.openxava.jpa.*;
import org.openxava.util.*;
import org.openxava.xavaprojects.model.*;
import org.openxava.xavaprojects.model.Period;

/**
 * 
 * @author Javier Paniza
 */

public class MyCalendarTest extends WebDriverTestBase {
	
	private int year = Dates.getYear(new Date());
	private int month = Dates.getMonth(new Date());
	
	protected void setUp() throws Exception {
		super.setUp();
		XPersistence.setPersistenceUnit("junit");
	}
		
	public void testCreateIssue() throws Exception {
		goModule("MyCalendar");
		login("javi", "javi");

		assertNewWithNoPlan();		
		createPlanForMonth(year, month);		
		assertNewWithNoDefaultForStatusAndType();
		
		clickOnDay(year, month, 15);
		assertNoErrors();
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "Javi " + year + "." + month);	
		
		execute("MyCalendar.save"); 
		assertError("Value for Title in Issue is required");

		setValue("title", "JUnit incident from My calendar");
		execute("MyCalendar.save"); 
		assertNoErrors(); 
		
		assertDayText(year, month, 15, "JUnit incident from My calendar"); 
		
		execute("MyCalendar.new");
		assertNoErrors();
		assertValue("plannedFor", month + "/" + Dates.getDay(new Date()) + "/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "Javi " + year + "." + month);	
		
		logout();
		login("juan", "juan");
		goModule("MyCalendar");
		assertDayText(year, month, 15, "");
		
		deleteData("JUnit incident from My calendar");
	}

	private void assertNewWithNoDefaultForStatusAndType() throws Exception {
		IssueStatus issueStatus = IssueStatus.findTheDefaultOneForMyCalendar();
		issueStatus.setUseAsDefaultValueForMyCalendar(false);
		String issueStatusId = issueStatus.getId();
		
		IssueType issueType = IssueType.findTheDefaultOneForMyCalendar();
		issueType.setUseAsDefaultValueForMyCalendar(false);
		String issueTypeId = issueType.getId();
		
		XPersistence.commit();
		
		clickOnDay(year, month, 15);
		
		assertNoErrors();
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "");
		assertDescriptionValue("status.id", "Pending");  
		assertDescriptionValue("assignedTo.id", "Javi " + year + "." + month);
		
		IssueStatus.findById(issueStatusId).setUseAsDefaultValueForMyCalendar(true);
		IssueType.findById(issueTypeId).setUseAsDefaultValueForMyCalendar(true);
		XPersistence.commit();
		
		execute("Mode.list");
	}

	private void assertNewWithNoPlan() throws Exception {
		clickOnDay(year, month, 15);
		assertError("There is no plan for javi on the date " + year + "-" + month + "-15. Create one and set it in the Assigned to field");
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "");
		execute("Mode.list");
	}

	private void clickOnDay(int year, int month, int day) throws Exception {
		WebElement dayElement = getDayElement(year, month);
		dayElement.click();
		wait(getDriver());
	}
	
	private void assertDayText(int year, int month, int day, String expectedText) throws Exception {
		WebElement dayElement = getDayElement(year, month);
		String expectedDayContent = Is.emptyString(expectedText)?Integer.toString(day): day + "\n" + expectedText; 
		assertEquals(expectedDayContent, dayElement.getText());
	}
	
	private WebElement getDayElement(int year, int month) {
		String date =  year + "-" + month + "-15";
		WebElement dayElement = getDriver().findElement(By.cssSelector("td[data-date='" + date + "']")); 
		return dayElement;
	}	

	private void createPlanForMonth(int year, int month) throws Exception {
		org.openxava.xavaprojects.model.Period period = new Period();
		period.setName(year + "." + month);
		period.setStartDate(LocalDate.of(year, month, 1));
		period.setEndDate(YearMonth.now().atEndOfMonth()); 
		
		Plan plan = new Plan();
		plan.setWorker(Worker.findById("4028808d7eea19fe017eea56ed120018")); // Javi
		plan.setPeriod(period);
		
		XPersistence.getManager().persist(period);
		XPersistence.getManager().persist(plan);
		
		XPersistence.commit();
	}
	
	private void deleteData(String issueTitle) {
		Issue issue = Issue.findByTitle(issueTitle);
		EntityManager pm = XPersistence.getManager();
		pm.remove(issue);
		Plan plan = issue.getAssignedTo();
		pm.remove(plan);
		pm.remove(plan.getPeriod());
		XPersistence.commit();
	}

}
