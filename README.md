# Selenium-Jbehave
Selenium with BDD 


Overview 
-About Project
-Project Structure
-Steps to run the project



About Project: 
This Automation project is using Selenium and Jbehave (BDD) for writing the automation scripts.
Includes the scenarios based on an Online Bus Ticket Booking WebSite "https://www.abhibus.com/"
Scenarios will check login functionality, will check the home page labels, will perform Enquiry for Bus seat availability etc.


Project Structure: 
Please see below snapshots for the same: 











	


screenshot 1


screenshot 2

screenshot 3





screenshot 4




screenshot 5





screenshot 6






screenshot 7



screenshot 8


screenshot 9









Steps to run scripts

1.
Checkout the project to your local: 
There are test cases written in Jbehave  format in Jbehave story files so each test case has its unique meta id. 

	2.
   -Execution through Eclipse
-go to eclipse and run as configuration and select maven build.
-Then give the values to the variables as 
 goal = clean verify
profiles =my-integration-test
 meta.filter =+ <Meta ID of jbehave scenarios>
 i.e. meta.filter= +100.01
Base_Url = https://www.abhibus.com/

-Then run it.
-There will be report generated in path  src/main/resources/reports with name having Automation_test_report + time stamp


screenshot 10
-Execute through Command line.
         Command to execute single test case.
i.e.
mvn clean verify -Dmy-integration-test  -Dmeta.filter="+100.01" -DBase_Url =https://www.abhibus.com/
         where 100.01 is meta id of test case.
if you want to run more than one test cases then
i.e.
mvn clean verify -Dmy-integration-test  -Dmeta.filter="+100.01 +100.02" -DBase_Url =https://www.abhibus.com/

if you want to run all the test cases of Story file then use meta id of Story file instead of using meta ids of single scenarios separately,
i.e.
mvn clean verify -Dmy-integration-test  -Dmeta.filter="+runAll" -DBase_Url =https://www.abhibus.com/

if you want to run all the test cases except some test cases then see below
i.e.
mvn clean verify -Dmy-integration-test  -Dmeta.filter="+runAll -100.01" -DBase_Url =https://www.abhibus.com/

Reference regarding Report : 
http://extentreports.relevantcodes.com/
I have observed there are lots of things are need to be customized for extent reports for BDD 
So I have done many customizations for my BDD project to get desired functionality from Extent report.


