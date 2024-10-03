package org.openxava.xavaprojects.tests;

import java.util.*;

import org.openqa.selenium.*;
import org.openxava.util.*;

/**
 * tmr
 * @author Javier Paniza
 */

public class MyCalendarTest extends WebDriverTestBase {
	
	protected boolean isHeadless() {
		return false;
	}
	
	protected void tearDown() throws Exception { // tmr Para no cierre el navegador
	}
	
	public void testCreateIssueFromADay() throws Exception {
		goModule("MyCalendar");
		login("javi", "javi");
		int year = Dates.getYear(new Date());
		int month = Dates.getMonth(new Date());
		String date =  year + "-" + month + "-15";
		WebElement day15 = getDriver().findElement(By.cssSelector("td[data-date='" + date + "']"));
		day15.click();
		wait(getDriver());
		assertMessage("You should create it and assign to this issue");
		assertValue("plannedFor", month + "/15/" + year);
		assertDescriptionValue("type.id", "Task");
		assertDescriptionValue("status.id", "Planned");
		assertDescriptionValue("assignedTo.id", "");
		createPlanCurrentMonth();
		execute("Mode.list");
	}

	private void createPlanCurrentMonth() {
		// TMR ME QUEDÉ POR AQUÍ
		// TMR ¿LLAMANDO AL MÓDULO? ¿O POR JPA?		
	}
	
}
