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
		


## Build the project
From command line prompt inside xavaprojects folder type:

	mvn clean package

## Configure database
You need to have installed and running a MySQL database. If not, go to [MySQL site](https://www.mysql.com/) and download and install it.
Edit the *xavaprojects/src/main/webapp/META-INF/context.xml* file to put the correct user name and password for your MySQL database:

	   <Resource name="jdbc/xavaprojectsDS" auth="Container" type="javax.sql.DataSource"
	      maxTotal="20" maxIdle="5" maxWaitMillis="10000"
	      username="YOUR USERNAME HERE" 
	      password="YOUR PASSWORD HERE" 
	      driverClassName="com.mysql.cj.jdbc.Driver"
	      url="jdbc:mysql://localhost:3306?serverTimezone=GMT%2B1"/>

Fill the *username* and *password* attributes.

## Run XavaProjects
To run XavaProjects in Windows:

	c:\> java -cp "target/xavaprojects/WEB-INF/classes;target/xavaprojects/WEB-INF/lib/*" org.openxava.xavaprojects.run.xavaprojects

To run your application in Linux or Mac:
	
	$ java -cp "target/xavaprojects/WEB-INF/classes:target/xavaprojects/WEB-INF/lib/*" org.openxava.xavaprojects.run.xavaprojects

The difference is the separator ; or :
Also you should be able to use it from Eclipse, IntelliJ, NetBeans, Visual Studio Code or any other IDE with Maven support.	

## Any problem?
Put a question in the [OpenXava public forum](https://sourceforge.net/p/openxava/discussion/419690/).
