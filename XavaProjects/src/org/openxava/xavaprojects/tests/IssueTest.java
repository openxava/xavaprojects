package org.openxava.xavaprojects.tests;

import java.time.*;
import java.time.format.*;
import java.util.*;

import org.openxava.tests.*;

/**
 * 
 * @author Javier Paniza
 */

public class IssueTest extends ModuleTestBase {

	public IssueTest(String nameTest) {
		super(nameTest, "XavaProjects", "Issue");
	}
	
	public void testCreateNewIssue() throws Exception {
		login("admin", "admin"); 
		setValue("title", "JUnit Incident");
		String [][] types = {
			{ "", "" },	
			{ "402880426d5f6588016d5f70e3920001", "Bug" },
			{ "402880426d5f6588016d5f7100650002", "Feature" }
		};
		assertValidValues("type.id", types);
		setValue("type.id", "402880426d5f6588016d5f70e3920001");
		setValue("description", "This is a JUnit Incident");
		assertValidValuesCount("project.id", 2);
		assertDescriptionValue("project.id", "OpenXava"); 		
		assertValue("createdBy", "admin");
		assertNoEditable("createdBy");
		assertValue("createdOn", getCurrentDate());

		String [][] priorities = {
			{ "", "" },
			{ "7", "7 High" },
			{ "5", "5 Normal" },
			{ "3", "3 Low" }
		};
		assertValidValues("priority.level", priorities);
		assertValue("priority.level", "5");
		setValue("priority.level", "7");

		String [][] versions = {
			{ "", "" },
			{ "402880426d5f6588016d5f7135ee0004", "2.0" },
			{ "402880426d5f6588016d5f7129ce0003", "1.0" }
		};
		assertValidValues("version.id", versions);
		setValue("version.id", "402880426d5f6588016d5f7129ce0003");		
			
		String [][] plans = {
			{ "", "" },	
			{ "402880406dfa06e9016dfa0925830003", "Javi 2019.10" },
			{ "402880406dfa06e9016dfa16f9160006", "Javi 2019.11" }
		};
		assertValidValues("assignedTo.id", plans);
		setValue("assignedTo.id", "402880406dfa06e9016dfa16f9160006");		
		
		String [][] customers = {
			{ "", "" },	
			{ "402880466eae0e5b016eae13f9f70002", "Banco Santander" },
			{ "402880466eae0e5b016eae13e29b0001", "Oracle Corporation" }
		};
		
		assertValidValues("customer.id", customers);
		setValue("customer.id", "402880466eae0e5b016eae13f9f70002");		

		assertValue("hours", "");
		setValue("minutes", "90");
		assertValue("hours", "1.50");
		assertNoEditable("hours");
		
		setValue("closed", "true");
		uploadFile("attachments", "test-files/notes.txt");
		uploadFile("screenshots", "test-files/issue-screenshot.png");
		postDiscussionComment("discussion", "I agree");
		
		execute("CRUD.save");
		execute("Mode.list");
		
		changeModule("Version");
		assertValueInList(1, 0, "OpenXava");
		assertValueInList(1, 1, "1.0");
		execute("List.viewDetail", "row=1");
		assertDescriptionValue("project.id", "OpenXava");  
		assertValue("name", "1.0");
		assertCollectionRowCount("issues", 1);
		assertValueInCollection("issues", 0, 0, "JUnit Incident");
		
		changeModule("Issue");
		assertListRowCount(1);
		assertValueInList(0, 0, "JUnit Incident");
		execute("List.viewDetail", "row=0");
		
		assertValue("title", "JUnit Incident");
		assertValue("type.id", "402880426d5f6588016d5f70e3920001");
		assertValue("description", "This is a JUnit Incident");
		assertDescriptionValue("project.id", "OpenXava"); 
		assertValue("createdBy", "admin");
		assertValue("createdOn", getCurrentDate());
		assertValue("priority.level", "7"); 
		assertValue("version.id", "402880426d5f6588016d5f7129ce0003"); 
		assertValue("assignedTo.id", "402880406dfa06e9016dfa16f9160006");
		assertValue("customer.id", "402880466eae0e5b016eae13f9f70002");		
		assertValue("minutes", "90");
		assertValue("hours", "1.50");		
		assertValue("closed", "true");
		
		assertFile("attachments", 0, "text/plain");
		assertFile("screenshots", 0, "image");
		assertDiscussionCommentsCount("discussion", 1);
		assertDiscussionCommentContentText("discussion", 0, "I agree");
		
		removeFile("screenshots", 0);
		execute("CRUD.delete");
		assertNoErrors();
	}
	
	private String getCurrentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ENGLISH));
	}

}
