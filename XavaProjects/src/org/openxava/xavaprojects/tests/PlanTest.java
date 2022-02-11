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
			/* tmr
			{"402880406dfa06e9016dfa0897340001", "Javi"},
			{"402880406dfea11b016dfef3623f0004", "Pedro"}
			*/
			// tmr ini
			{"4028808d7eea19fe017eea56ed120018", "Javi"},
			{"4028808d7eea19fe017eea56ffeb0019", "Pedro"}
			// tmr fin
		};
		assertValidValues("worker.id", workers);
		// tmr setValue("worker.id", "402880406dfea11b016dfef3623f0004"); // Pedro
		setValue("worker.id", "4028808d7eea19fe017eea56ffeb0019"); // Pedro // tmr
		
		String [][] periods = {
			{"", ""},
			/* tmr
			{"402880406dfa06e9016dfa08c7f60002", "2019.10"},
			{"402880406dfa06e9016dfa16c4ff0005", "2019.11"}
			*/
			// tmr ini
			{"4028808d7eea19fe017eea5a84e5001a", "2019.10"},
			{"4028808d7eea19fe017eea5ab6dc001b", "2019.11"}
			// tmr fin
		};
		assertValidValues("period.id", periods);
		// tmr setValue("period.id", "402880406dfa06e9016dfa16c4ff0005"); // 2019.11
		setValue("period.id", "4028808d7eea19fe017eea5ab6dc001b"); // 2019.11 // tmr
		
		execute("Collection.new", "viewObject=xava_view_issues");
		setValue("title", "The first step of my big plan");
		// tmr setValue("type.id", "402880426d5f6588016d5f70e3920001"); // Bug
		setValue("type.id", "4028808d7eea19fe017eea61bec90024"); // Bug // tmr
		execute("Collection.save");
		assertNoErrors();
		assertCollectionRowCount("issues", 1);
		
		execute("Mode.list");
		assertListRowCount(3);
		assertValueInList(1, 0, "Pedro");
		assertValueInList(1, 1, "2019.11");
		
		execute("List.viewDetail", "row=1"); 
		/* tmr
		assertValue("worker.id", "402880406dfea11b016dfef3623f0004"); // Pedro
		assertValue("period.id", "402880406dfa06e9016dfa16c4ff0005"); // 2019.11
		*/
		// tmr ini
		assertValue("worker.id", "4028808d7eea19fe017eea56ffeb0019"); // Pedro
		assertValue("period.id", "4028808d7eea19fe017eea5ab6dc001b"); // 2019.11		
		// tmr fin
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
