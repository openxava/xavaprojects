package _run;

import org.openxava.util.*;

/**
 * Execute this class to start the application.
 *
 * With Eclipse: Right mouse button > Run As > Java Application
 */

public class _Run_XavaProjects {

	public static void main(String[] args) throws Exception {
		// DBServer.start("XavaProjectsDB"); // We use MySQL
		AppServer.run("XavaProjects");
	}

}
