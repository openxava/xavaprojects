# XavaProjects

XavaProjects is an issue and project tracking application for software projects written with [OpenXava](https://www.openxava.org). For more information go to [XavaProjects site](https://www.openxava.org/XavaProjects).

## Install OpenXava

Go to [openxava.org](https://www.openxava.org) and download the latest OpenXava version. It's a zip, just uncompress it. Open the *quick-start.html* file and from there follow the *Getting Started* lesson, so you get used to OpenXava a little.

## Install XavaProjects

### Download it from GitHub
Click on the above green button *Clone or download* and choose *Download ZIP*. You'll get a file called *xavaprojects-master.zip*.

### Import it into Eclipse
Start Eclipse and choose as workspace the one included in the OpenXava distribution. 
From Eclipse:

 - Choose the option *File > Import...* . It will show a dialog.
 - In the folder *General* choose the option *Existing Project into Workspace*. 
 - Click on *Next*.
 - Choose *Select archive file*, and click on *Browse...*
 - Look for the file you have downloaded, *xavaprojects-master.zip*, and choose it.
 - Check *XavaProjects (xavaprojects-master/XavaProjects/)*.
 - Click on *Finish*.

Now, you should have the *XavaProjects* project in your workspace.

### Update XavaProjects with OpenXava
In *XavaProjects* project inside Eclipse look for the file *build.xml*, with the right mouse button select *Run As > Ant Build...* . This will open a dialog, where you have to uncheck *desployWar* and check *updateOX*. Then click on *Finish*. After the ant task completes, select the *XavaProjects* project and click F5 to refresh it. Finally, press Ctrl-B to build the project.

## Configure database
You need to have installed and running a MySQL database. If not, go to [MySQL site](https://www.mysql.com/) and download and install it.
Edit the *XavaProjects/web/META-INF/context.xml* file to put the correct user name and password for your MySQL database:

	   <Resource name="jdbc/XavaProjectsDS" auth="Container" type="javax.sql.DataSource"
	      maxTotal="20" maxIdle="5" maxWaitMillis="10000"
	      username="YOUR USERNAME HERE" 
	      password="YOUR PASSWORD HERE" 
	      driverClassName="com.mysql.jdbc.Driver"
	      url="jdbc:mysql://localhost:3306?serverTimezone=GMT%2B1"/>
Fill the *username* and *password* attributes.

## Run XavaProjects
From Eclipse open *XavaProjects > src > _run*. There you have a class called *_Run_XavaProjects*, just click on *Run As > Java Application* on it. Wait a few seconds, until see a message in console saying "Application started". Then, open your browser on http://localhost:8080/XavaProjects

 ## Any problem?
 Put a question in the [OpenXava public forum](https://sourceforge.net/p/openxava/discussion/419690/).
