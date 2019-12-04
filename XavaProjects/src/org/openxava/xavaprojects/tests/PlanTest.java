package org.openxava.xavaprojects.tests;

import org.openxava.tests.*;

/**
 * 
 * @author Javier Paniza
 */

public class PlanTest extends ModuleTestBase {

	public PlanTest(String nameTest) {
		super(nameTest, "XavaProjects", "Plan");
	}
	
	public void testCreateNewPlan() throws Exception {
		login("admin", "admin");
		assertListRowCount(2);
		execute("CRUD.new");
		
		String [][] workers = {
			{"", ""},
			{"402880406dfa06e9016dfa0897340001", "Javi"},
			{"402880406dfea11b016dfef3623f0004", "Pedro"}
		};
		assertValidValues("worker.id", workers);
		setValue("worker.id", "402880406dfea11b016dfef3623f0004"); // Pedro
		
		String [][] periods = {
			{"", ""},
			{"402880406dfa06e9016dfa08c7f60002", "2019.10"},
			{"402880406dfa06e9016dfa16c4ff0005", "2019.11"}			
		};
		assertValidValues("period.id", periods);
		setValue("period.id", "402880406dfa06e9016dfa16c4ff0005"); // 2019.11
		
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "The first step of my big plan");
		setValue("type.id", "402880426d5f6588016d5f70e3920001"); // Bug
		execute("Collection.save");
		assertNoErrors();
		assertCollectionRowCount("issues", 1);
		
		execute("Mode.list");
		assertListRowCount(3);
		assertValueInList(1, 0, "Pedro");
		assertValueInList(1, 1, "2019.11");
		
		execute("List.viewDetail", "row=1"); 
		assertValue("worker.id", "402880406dfea11b016dfef3623f0004"); // Pedro
		assertValue("period.id", "402880406dfa06e9016dfa16c4ff0005"); // 2019.11
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

}
