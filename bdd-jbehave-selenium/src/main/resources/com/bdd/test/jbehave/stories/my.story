Story: Includes the scenarios based on an Online Bus Ticket Booking WebSite "https://www.abhibus.com/"
		Scenario will check login functionality , will check the home page lables ,will perform Enquiry for Bus seat availability etc.
Meta: 
@runAll

Scenario: 100.01 Verify page lables
Meta:
@100.01

Given User has Launched the site
When user logs in with the credentials which are stored in excel at path as<filePath> for testcase as <testCaseName>
Then System should show all the correct page lables
And create Customized report <testCaseName>


Examples:

|filePath|testCaseName|
|src\\main\\resources\\test_data_sheet\\LoginExcel.xls|"100.01 Verify page lables"|


Scenario: 100.02 check Search result page
Meta:
@100.02

Given User has Launched the site
When user logs in with the credentials which are stored in excel at path as<filePath> for testcase as <testCaseName>
When user enquires for seat availabilty
Then System should show search result page
And create Customized report <testCaseName>


Examples:

|filePath|testCaseName|
|src\\main\\resources\\test_data_sheet\\LoginExcel.xls|"100.02 Verify page lables"|


Scenario: 100.03 Scenario to be failed
Meta:
@100.03

Given User has Launched the site
When User is on login page
Then System should show correct page title
And create Customized report <testCaseName>


Examples:

|filePath|testCaseName|
|src\\main\\resources\\test_data_sheet\\LoginExcel.xls|"100.03 Scenario to be failed"|

