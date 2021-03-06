# Selenium-Jbehave
Selenium with BDD 


##Overview 
About Project,
Project Structure,
Steps to run the project
Tools to be used



##About Project: 
The Automation project is using Selenium and Jbehave (BDD) for writing the automation scripts.
it includes the scenarios based on an Online Bus Ticket Booking WebSite "https://www.abhibus.com/"
Scenarios will check login functionality, will check the home page labels, will perform Enquiry for Bus seat availability etc.
In the end of execution it will create an execution report.


##Project Structure: 
Please see below snapshots for the same: 
screenshot 1
https://cloud.githubusercontent.com/assets/22616784/19104445/1f7887d2-8afa-11e6-86c5-d9cfc66726aa.png

screenshot 2
https://cloud.githubusercontent.com/assets/22616784/19104446/1f89661a-8afa-11e6-945a-054a6b64ed62.png

screenshot 3
https://cloud.githubusercontent.com/assets/22616784/19104438/1f41bb1c-8afa-11e6-9bd2-6e901752276f.PNG

screenshot 4
https://cloud.githubusercontent.com/assets/22616784/19104440/1f45a7f4-8afa-11e6-875d-eebcf5c8dc2e.PNG


screenshot 5
https://cloud.githubusercontent.com/assets/22616784/19104437/1f40105a-8afa-11e6-8bae-56bb0049723a.PNG


screenshot 6
https://cloud.githubusercontent.com/assets/22616784/19104439/1f43897e-8afa-11e6-8a8a-9e4dcb766241.PNG


screenshot 7
https://cloud.githubusercontent.com/assets/22616784/19104441/1f4fddd2-8afa-11e6-87f0-6acd8b40b7cf.PNG

screenshot 8
https://cloud.githubusercontent.com/assets/22616784/19104442/1f668d7a-8afa-11e6-8386-d0161665c283.PNG


screenshot 9
https://cloud.githubusercontent.com/assets/22616784/19104444/1f6d5510-8afa-11e6-9f8f-cfdf2fdc8573.PNG





##Steps to run scripts

1.
Checkout the project to your local: 
There are test cases written in Jbehave  format in Jbehave story files so each test case has its unique meta id. 




screenshot 10
https://cloud.githubusercontent.com/assets/22616784/19104443/1f6b4a4a-8afa-11e6-8e5c-ccbab0d278f5.PNG



###Execution through Eclipse
  
Go to eclipse and run as configuration and select maven build.
	Then give the values to the variables as 
	
	
 		goal = clean verify
		profiles =my-integration-test
		meta.filter =+meta ids of scenarios
 	        Base_Url = https://www.abhibus.com/
	
internally command will be formed like below


	mvn clean verify -Dmy-integration-test  -Dmeta.filter="+100.01" -DBase_Url =https://www.abhibus.com/
where 100.01 is meta id of test case.

Then run it.
There will be report generated in path  src/main/resources/reports with name having Automation_test_report + time stamp

###Execute through Command line

 Command to execute single test case.
	
 if you want to run more than one test cases then
	
	mvn clean verify -Dmy-integration-test  -Dmeta.filter="+100.01 +100.02" -DBase_Url =https://www.abhibus.com/

 if you want to run all the test cases of Story file then use meta id of Story file instead of using meta ids of single scenarios 	   separately,
	
	mvn clean verify -Dmy-integration-test  -Dmeta.filter="+runAll" -DBase_Url =https://www.abhibus.com/

 if you want to run all the test cases except some test cases then see below
	
	mvn clean verify -Dmy-integration-test  -Dmeta.filter="+runAll -100.01" -DBase_Url =https://www.abhibus.com/


###Selenium and Firefox Compatibility
I have faced many issues regarding compatibility between versions of Selenium and Firefox,
One valid compatible combination I have found as below,

	Selenium Vesrion 2.47 and Firefox 33.0 
	
If user faces compatibility issue for Selenium and firefox ,user is advised to use above versions for the same.

Reference regarding Report : 
http://extentreports.relevantcodes.com/
I have observed there are lots of things  need to be customized for extent reports for my BDD project
So I have done many customizations for my BDD project to get desired functionality from Extent report.







