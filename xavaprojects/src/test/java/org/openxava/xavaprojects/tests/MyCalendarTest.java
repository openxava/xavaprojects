package org.openxava.xavaprojects.tests;

import java.time.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openxava.jpa.*;
import org.openxava.util.*;
import org.openxava.xavaprojects.model.*;
import org.openxava.xavaprojects.model.Period;

/**
 * tmr
 * @author Javier Paniza
 */

public class MyCalendarTest extends WebDriverTestBase {
	
	protected boolean isHeadless() {
		return false;
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		XPersistence.setPersistenceUnit("junit");
	}
	
	protected void tearDown() throws Exception { // tmr Para no cierre el navegador
	}
	
	public void testCreateIssueFromADay() throws Exception {
		goModule("MyCalendar");
		login("javi", "javi");
		int year = Dates.getYear(new Date());
		int month = Dates.getMonth(new Date());

		clickOnDay(year, month, 15);
		assertMessage("You should create it and assign to this issue");
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "");
		
		createPlanForMonth(year, month);
		execute("Mode.list");
		
		clickOnDay(year, month, 15);
		assertNoMessages();
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "Javi " + year + "." + month);	
		
		setValue("title", "JUnit incident from My calendar");
		execute("CRUD.save");
		execute("Mode.list");
		
		assertDayText(year, month, 15, "JUnit incident from My calendar"); 
		
		// TMR ME QUEDÉ POR AQUÍ: FALTA COMPROBAR QUE SI ME IDENTIFICO CON OTRO USUARIO NO SALE AL INCIDENCIA
	}

	private void clickOnDay(int year, int month, int day) throws Exception {
		String date =  year + "-" + month + "-15";
		WebElement dayElement = getDriver().findElement(By.cssSelector("td[data-date='" + date + "']")); // tmr ¿Refactorizar con assertDayText?
		dayElement.click();
		wait(getDriver());
	}
	
	private void assertDayText(int year, int month, int day, String expectedText) throws Exception {
		String date =  year + "-" + month + "-15";
		WebElement dayElement = getDriver().findElement(By.cssSelector("td[data-date='" + date + "']"));
		System.out.println("[MyCalendarTest.assertDayText] dayElement.getText()=" + dayElement.getText()); // tmr
		assertEquals(day + "\n" + expectedText, dayElement.getText());
	}

	private void createPlanForMonth(int year, int month) throws Exception {
		org.openxava.xavaprojects.model.Period period = new Period();
		period.setName(year + "." + month);
		period.setStartDate(LocalDate.of(year, month, 1));
		period.setEndDate(LocalDate.of(year, month, 28)); // 28 to work for all months, enough for the test
		
		
		Plan plan = new Plan();
		plan.setWorker(XPersistence.getManager().find(Worker.class, "4028808d7eea19fe017eea56ed120018")); // Javi
		plan.setPeriod(period);
		
		XPersistence.getManager().persist(period);
		XPersistence.getManager().persist(plan);
		
		XPersistence.commit();
	}
	
}
