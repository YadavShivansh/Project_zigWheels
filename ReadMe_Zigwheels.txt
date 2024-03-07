************************************************PROJECT DESCRIPTION*****************************************************************
 
Problem Statement : Identify New Bikes
1. Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac.
2. For Used cars in Chennai, extract all the popular models in a List; Display the same
3. Try to 'Login' with google, give invalid account details & capture the error message

Detailed Description: Hackathon Project
1.Launch the browser.
2.Go to "https://zigwheels.com".
3.Cick on upcoming bikes.
4.Select manufacturer Honda.
5.Display upcoming bikes with price less than 4 lakhs.
6.Click on used cars and select city Chennai.
7.Display all popular models in a list.
8.Click on each popular model and display the details of the car.
9.Click on Signin/Register button
10.Select google and give invalid email.
11.Capture the error message.
12.Navigate back to homepage.
13.Close the browser.

 
Key Automation Scope:
 
Capturing the screenshot
Navigation to new page
Printing  the values in console and excel sheet

 
 
**********************************************************STEPS TO EXECUTE*************************************************************
 
-unzip the folder
-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location where u unzip the folder-> click on finish
-Now go to the TestRunner and run as TestNG or Junit .
-Now the file will Execute and we get the expected output as shown below.
 
*******************************************************FILES DESCRIPTION**************************************************************
 
1.src/test/java- There are five packages in this folder.

-> Factory   :In this package there is one class Baseclass.

->PageObjects : In this file required oageObjects are defined named as the Basepage,fundamentalElements,login , loginFb,loginGoogle,newBikes,newbikesFilter,newCars, and Used Cars classes are defined.

->StepDefinitions : In this file,stepDef1,stepDef2,Hooks classes are defined.

->TestRunner  : In this file, testRun class is defined.

->Utilitis   : In this file, Excelsheet class and Helper class  is defined.
 
2.src/test/resources- There are two folders in this folder.

->Excel  : In this folder, there are NewBikes.xlsx, config.properties, extent.properties and log4j2.xml are defined.


3.JRE System Library: In this File we have all dependencies of JAR.files.         
 
4.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

5.Features  : In this folder, there are Regression,End To End  and smokes feature files are defined. 
 
6.reports: In this folder the myreport.html is present which is the report of the project
 
7.src: In this, there are two folders
	-main:It is an empty folder
	-test:It is an empty folder
 
8.target: It is an empty folder

9.test-output:In this spark report is present . 

10.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

11.testng.xml : In this file, xml code is there.
 

***************************************************************************************************************************************
 
