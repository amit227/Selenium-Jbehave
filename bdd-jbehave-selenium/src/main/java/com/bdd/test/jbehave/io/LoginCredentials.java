package com.bdd.test.jbehave.io;

import java.util.ArrayList;
import java.util.List;

public class LoginCredentials {
	List<String> listOfUserNames = new ArrayList<String>();
	List<String> listOfTestCaseIDs = new ArrayList<String>();
	List<String> listOfPasswords = new ArrayList<String>();
	ExcelCustomerData excelCustomerData = null;
	String filePath = null;
	String filePathFromStory = null;
	String testCaseName = null;
	String userName = null;
	String password = null;

	public LoginCredentials(String filePath, String testCaseName) {
		
		this.filePath = filePath;
		this.testCaseName = testCaseName;

	}

	public String[] readLoginCredentialsFromExcel() {

		int rowIndexToReadCredentials = -1;
		Boolean reportingFlag = null;
		String[] loginCredentials = new String[2];
		excelCustomerData = new ExcelCustomerData();
		
		
		listOfTestCaseIDs = excelCustomerData.getColumnFromExcelSheet(filePath, 0, 0);
		listOfUserNames = excelCustomerData.getColumnFromExcelSheet(filePath, 0, 1);
		listOfPasswords = excelCustomerData.getColumnFromExcelSheet(filePath, 0, 2);
		
		for (int index = 0; index < listOfTestCaseIDs.size(); index++) {
			System.out.println("TestcaseId at index " + index + " : " + listOfTestCaseIDs.get(index));

			if (testCaseName.contains(listOfTestCaseIDs.get(index))) {
				rowIndexToReadCredentials = index;
				System.out.println("break");
				break;
			}

			if (index == listOfTestCaseIDs.size() - 1) {
				reportingFlag = Boolean.FALSE;
				System.out.println("No Test case ID matches with Given Test case");

			}

		}
		
		if(rowIndexToReadCredentials !=-1)
		{
			
			System.out.println("rowIndexToReadCredentials : " + rowIndexToReadCredentials);
			userName = listOfUserNames.get(rowIndexToReadCredentials);
			password = listOfPasswords.get(rowIndexToReadCredentials);
			
			loginCredentials[0] = userName;
			loginCredentials[1] = password;
			
		}
		
		
		
		return loginCredentials;

	}

}
