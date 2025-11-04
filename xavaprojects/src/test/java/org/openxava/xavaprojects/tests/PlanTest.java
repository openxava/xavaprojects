package org.openxava.xavaprojects.tests;

import java.time.*;
import java.time.format.*;

import org.openxava.tests.*;

/**
 * 
 * @author Javier Paniza
 */

public class PlanTest extends ModuleTestBase {

	public PlanTest(String nameTest) {
		super(nameTest, "xavaprojects", "Plan");
	}
	
	public void testCreateNewPlan() throws Exception { 
		login("admin", "admin");
		assertListRowCount(2);
		execute("CRUD.new");
		
		String [][] workers = {
			{"", ""},
			{"4028808d7eea19fe017eea56ed120018", "Javi"},
			{"4028808d7eea19fe017eea56ffeb0019", "Pedro"}
		};
		assertValidValues("worker.id", workers);
		setValue("worker.id", "4028808d7eea19fe017eea56ffeb0019"); // Pedro 
		
		String [][] periods = {
			{"", ""},
			{"4028808d7eea19fe017eea5a84e5001a", "2019.10"},
			{"4028808d7eea19fe017eea5ab6dc001b", "2019.11"}
		};
		assertValidValues("period.id", periods);
		setValue("period.id", "4028808d7eea19fe017eea5ab6dc001b"); // 2019.11 
		
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "The first step of my big plan");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug 
		execute("Collection.save");
		assertNoErrors();
		assertCollectionRowCount("issues", 1);
		
		execute("Mode.list");
		assertListRowCount(3);
		assertValueInList(1, 0, "Pedro");
		assertValueInList(1, 1, "2019.11");

		execute("List.viewDetail", "row=0");
		execute("Navigation.next");
		assertNoErrors(); // To test a bug with plannedFor data formatter when navigating
		
		assertValue("worker.id", "4028808d7eea19fe017eea56ffeb0019"); // Pedro
		assertValue("period.id", "4028808d7eea19fe017eea5ab6dc001b"); // 2019.11		
		assertCollectionRowCount("issues", 1);
		assertValueInCollection("issues", 0, 0, "The first step of my big plan");
		execute("Collection.removeSelected", "row=0,viewObject=xava_view_issues");
		execute("CRUD.delete");
		assertNoErrors();
		
		changeModule("Issue");
		assertListRowCount(1);
		assertValueInList(0, 0, "The first step of my big plan");
		assertValueInList(0, 1, "Bug");
		checkAll();
		execute("CRUD.deleteSelected");
		assertNoErrors();
	}

	
	public void testDeadlineDateListFormatter() throws Exception { 
		login("admin", "admin");
		
		// Get the first plan
		execute("List.viewDetail", "row=0");
		
		// Calculate working day dates
		LocalDate today = LocalDate.now();
		LocalDate lastWorkingDay = getPreviousWorkingDay(today);
		LocalDate secondLastWorkingDay = getPreviousWorkingDay(lastWorkingDay);
		LocalDate otherDate = LocalDate.of(2025, 3, 15);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		// Add issue for today
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "Issue for today");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug
		setValue("plannedFor", today.format(formatter));
		execute("Collection.save");
		assertNoErrors();
		
		// Add issue for last working day (yesterday)
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "Issue for yesterday");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug
		setValue("plannedFor", lastWorkingDay.format(formatter));
		execute("Collection.save");
		assertNoErrors();
		
		// Add issue for second last working day (day before yesterday)
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "Issue for day before yesterday");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug
		setValue("plannedFor", secondLastWorkingDay.format(formatter));
		execute("Collection.save");
		assertNoErrors();
		
		// Add issue for other date
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "Issue for other date");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug
		setValue("plannedFor", otherDate.format(formatter));
		execute("Collection.save");
		assertNoErrors();
		
		// Verify the collection has 4 issues
		assertCollectionRowCount("issues", 4);
		
		// Get the HTML and verify the CSS classes are applied correctly to the right dates
		String html = getHtml();
		
		// Format dates as they appear in the HTML (M/d/yyyy format for English locale)
		DateTimeFormatter htmlFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		String todayFormatted = today.format(htmlFormatter);
		String yesterdayFormatted = lastWorkingDay.format(htmlFormatter);
		String dayBeforeYesterdayFormatted = secondLastWorkingDay.format(htmlFormatter);
		String otherDateFormatted = otherDate.format(htmlFormatter);
		
		// Verify today's date has the 'deadline-today' class
		assertTrue("Today's date (" + todayFormatted + ") should have 'deadline-today' class", 
			html.contains("<span class=\"deadline-today\">" + todayFormatted + "</span>") || 
			html.contains("<span class='deadline-today'>" + todayFormatted + "</span>"));
		
		// Verify yesterday's date has the 'deadline-yesterday' class
		assertTrue("Yesterday's date (" + yesterdayFormatted + ") should have 'deadline-yesterday' class", 
			html.contains("<span class=\"deadline-yesterday\">" + yesterdayFormatted + "</span>") || 
			html.contains("<span class='deadline-yesterday'>" + yesterdayFormatted + "</span>"));
		
		// Verify day before yesterday's date has the 'deadline-day-before-yesterday' class
		assertTrue("Day before yesterday's date (" + dayBeforeYesterdayFormatted + ") should have 'deadline-day-before-yesterday' class", 
			html.contains("<span class=\"deadline-day-before-yesterday\">" + dayBeforeYesterdayFormatted + "</span>") || 
			html.contains("<span class='deadline-day-before-yesterday'>" + dayBeforeYesterdayFormatted + "</span>"));
		
		// Verify other date has no special class (no span wrapper)
		assertFalse("Other date (" + otherDateFormatted + ") should not have any deadline class", 
			html.contains("<span class=\"deadline-today\">" + otherDateFormatted + "</span>") ||
			html.contains("<span class=\"deadline-yesterday\">" + otherDateFormatted + "</span>") ||
			html.contains("<span class=\"deadline-day-before-yesterday\">" + otherDateFormatted + "</span>"));

		// Clean up: remove all issues
		checkAllCollection("issues");
		execute("Collection.deleteSelected", "viewObject=xava_view_issues");
		
		assertCollectionRowCount("issues", 0);
	}
	
	private LocalDate getPreviousWorkingDay(LocalDate date) {
		LocalDate previousDay = date.minusDays(1);
		while (previousDay.getDayOfWeek() == DayOfWeek.SATURDAY || 
			   previousDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
			previousDay = previousDay.minusDays(1);
		}
		return previousDay;
	}

}
