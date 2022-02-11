package org.openxava.xavaprojects.tests;

import java.time.*;
import java.time.format.*;

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
			/* tmr
			{ "402880426d5f6588016d5f70e3920001", "Bug" },
			{ "402880426d5f6588016d5f7100650002", "Feature" }
			*/
			// tmr ini
			{ "4028808d7eea19fe017eea61bec90024", "Bug" },
			{ "4028808d7eea19fe017eea61d4f20025", "Feature" }
			// tmr fin
		};
		assertValidValues("type.id", types);
		// tmr setValue("type.id", "402880426d5f6588016d5f70e3920001");
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug tmr
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
			/* tmr
			{ "402880426d5f6588016d5f7135ee0004", "2.0" },
			{ "402880426d5f6588016d5f7129ce0003", "1.0" }
			*/
			// tmr ini
			{ "4028808d7eea19fe017eea5074130012", "2.0" },
			{ "4028808d7eea19fe017eea5057f30011", "1.0" }
			// tmr fin
		};
		assertValidValues("version.id", versions);
		// tmr setValue("version.id", "402880426d5f6588016d5f7129ce0003");		
		setValue("version.id", "4028808d7eea19fe017eea5057f30011"); // 1.0 tmr
			
		String [][] plans = {
			{ "", "" },	
			/* tmr
			{ "402880406dfa06e9016dfa0925830003", "Javi 2019.10" },
			{ "402880406dfa06e9016dfa16f9160006", "Javi 2019.11" }
			*/
			// tmr ini
			{ "4028808d7eea19fe017eea5b5534001e", "Javi 2019.10" },
			{ "4028808d7eea19fe017eea5b675b001f", "Javi 2019.11" }
			// tmr fin
		};
		assertValidValues("assignedTo.id", plans);
		// tmr setValue("assignedTo.id", "402880406dfa06e9016dfa16f9160006");		
		setValue("assignedTo.id", "4028808d7eea19fe017eea5b675b001f"); // 2019.11 tmr
		
		String [][] status = {
			{ "", "" },	
			/* tmr
			{ "4028b881715acc4301715adab58c0003", "Done" },
			{ "4028b881715acc4301715aecad7e0004", "Not reproducible" },
			{ "4028b881715acc4301715ad9ab010002", "Pending" },
			{ "4028b881715acc4301715af05d8b0005", "Rejected" }
			*/
			// tmr ini
			{ "4028808d7eea19fe017eea2160df0002", "Done" },
			{ "4028808d7eea19fe017eea2272ae0003", "Not reproducible" },
			{ "4028808d7eea19fe017eea1e4ffb0001", "Pending" },
			{ "4028808d7eea19fe017eea2380970004", "Rejected" }
			// tmr fin
		};
		
		assertValidValues("status.id", status);
		// tmr assertValue("status.id", "4028b881715acc4301715ad9ab010002");		
		assertValue("status.id", "4028808d7eea19fe017eea1e4ffb0001"); // Pending tmr
		
		// TMR ME QUEDÉ POR AQUÍ, ESTABA ACTUALIZANDO LOS OIDS
		
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
		
		uploadFile("attachments", "test-files/notes.txt");
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
		assertValue("createdOn", getCurrentDate()); // If fails revise the serverTimezone in MySQL url
		assertValue("priority.level", "7"); 
		assertValue("version.id", "402880426d5f6588016d5f7129ce0003"); 
		assertValue("assignedTo.id", "402880406dfa06e9016dfa16f9160006");
		assertValue("status.id", "4028b881715acc4301715ad9ab010002"); 
		assertValue("customer.id", "402880466eae0e5b016eae13f9f70002");		
		assertValue("minutes", "90");
		assertValue("hours", "1.50");		
		
		assertFile("attachments", 0, "text/plain");
		assertDiscussionCommentsCount("discussion", 1);
		assertDiscussionCommentContentText("discussion", 0, "I agree");
		
		execute("CRUD.delete");
		assertNoErrors();
	}
	
	public void testMinimalIssue() throws Exception {
		login("admin", "admin"); 
		setValue("title", "JUnit Simple Incident");
		String [][] types = {
			{ "", "" },
			/* tmr
			{ "402880426d5f6588016d5f70e3920001", "Bug" },
			{ "402880426d5f6588016d5f7100650002", "Feature" }
			*/
			// tmr ini
			{ "4028808d7eea19fe017eea61bec90024", "Bug" },
			{ "4028808d7eea19fe017eea61d4f20025", "Feature" }
			// tmr fin
		};
		assertValidValues("type.id", types);
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug
		setValue("description", "This is a JUnit Incident");
		
		execute("CRUD.save");
		assertNoErrors();
		execute("Mode.list");
		assertListRowCount(1);
		assertValueInList(0, 0, "JUnit Simple Incident");
		execute("List.viewDetail", "row=0");
		
		assertValue("title", "JUnit Simple Incident");
		// tmr assertValue("type.id", "402880426d5f6588016d5f70e3920001");
		assertValue("type.id", "4028808d7eea19fe017eea61bec90024"); // tmr
		assertValue("description", "This is a JUnit Incident");
		assertValue("createdBy", "admin");
		assertValue("createdOn", getCurrentDate());

		execute("CRUD.delete");
		assertNoErrors();		
	}
	
	private String getCurrentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")); 
	}

}
