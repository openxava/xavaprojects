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
		assertValue("createdBy", "admin");
		assertNoEditable("createdBy");
		String [][] versions = {
			{ "", "" },	
			{ "402880426d5f6588016d5f7129ce0003", "1.0" },
			{ "402880426d5f6588016d5f7135ee0004", "2.0" }
		};
		assertValidValues("version.id", versions);
		setValue("version.id", "402880426d5f6588016d5f7129ce0003");		
		setValue("closed", "true");
		assertValue("createdOn", getCurrentDate());
		uploadFile("attachments", "test-files/notes.txt");
		uploadFile("screenshots", "test-files/issue-screenshot.png");
		postDiscussionComment("discussion", "I agree");
		
		execute("CRUD.save");
		execute("Mode.list");
		
		changeModule("Version");
		assertValueInList(0, 0, "1.0");
		execute("List.viewDetail", "row=0");
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
		assertValue("createdBy", "admin");
		assertValue("version.id", "402880426d5f6588016d5f7129ce0003"); 
		assertValue("closed", "true");
		assertValue("createdOn", getCurrentDate());
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
