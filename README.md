# XavaProjects

XavaProjects is an issue and project tracking application for software projects written with [OpenXava](https://www.openxava.org). For more information go to [XavaProjects site](https://www.openxava.org/xavaprojects).

## Prerequisites
You need Java and Maven installed

## Adjust dependencies
Edit the pom.xml and remove or comment the next dependencies:

	<!-- For XavaPro --> 
	<dependency>
		<groupId>com.openxava</groupId>
		<artifactId>xavapro</artifactId>
		<version>${openxava.version}</version>
	</dependency>	
		
	<dependency>
		<groupId>org.openxava</groupId>
		<artifactId>xavaprojects-email-conf</artifactId>
		<version>1.0</version>
	</dependency>
		
Then in the same pom.xml uncomment the next dependency:

	<!-- For plain OpenXava --> 
	<dependency>
		<groupId>org.openxava</groupId>
		<artifactId>openxava</artifactId>
		<version>${openxava.version}</version>
	</dependency>		


## Configure database
You need to have installed and running a MySQL database. If not, go to [MySQL site](https://www.mysql.com/) and download and install it.
Edit the *xavaprojects/src/main/resources/application.properties* file to put the correct user name and password for your MySQL database:

	spring.datasource.username=YOUR USERNAME HERE
	spring.datasource.password=YOUR PASSWORD HERE
	spring.datasource.url=jdbc:mysql://localhost:3306/XavaProjects?serverTimezone=GMT%2B1
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

Fill the *spring.datasource.username* and *spring.datasource.password* properties.

If you want the email reminders to be remembered when the application is restarted, you have to create the Quartz tables using the following scripts:
https://github.com/quartz-scheduler/quartz/tree/main/quartz/src/main/resources/org/quartz/impl/jdbcjobstore

## Run XavaProjects
From command line prompt inside xavaprojects folder type:

	mvn spring-boot:run

Then go to http://localhost:8080/xavaprojects with your browser.
Also you should be able to run it from Eclipse, IntelliJ, NetBeans, Visual Studio Code or any other IDE with Maven support, executing the main() method of org.openxava.xavaprojects.XavaprojectsApplication.

To produce a deployable WAR for an external servlet container:

	mvn clean package -Dmaven.test.skip

## Any problem?
Put a question in the [OpenXava public forum](https://sourceforge.net/p/openxava/discussion/419690/).
