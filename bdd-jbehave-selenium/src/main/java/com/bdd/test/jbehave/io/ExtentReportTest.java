package com.bdd.test.jbehave.io;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest {

	static String fileName = new SimpleDateFormat("yyyy-MM-dd'_'HH-mm-ss'.html'").format(new Date());
	static ExtentReports extent = new ExtentReports("src/main/resources/reports/AutomationTestReport_" + fileName,
			true);
	List<String> childNodesList = new ArrayList<String>();
	List<String> childNodesStatusList = new ArrayList<String>();
	List<String> childNodesStatusInfoList = new ArrayList<String>();
	List<String> childNodeScreenShotList = new ArrayList<String>();
	List<ExtentTest> childNodesListFinal = new ArrayList<ExtentTest>();
	String screenShotHTMLTag = null;
	String test = null;

	public ExtentReportTest(String test, Map<String, List<String>> childInfoMap) {
		// TODO Auto-generated constructor stub

		this.test = test;

		int i = 0;
		for (Map.Entry<String, List<String>> childinfo : childInfoMap.entrySet()) {
			String key = childinfo.getKey().toString();
			;
			List<String> value = childinfo.getValue();
			childNodesList.add(key);
			childNodesStatusInfoList.add(value.get(i));
			childNodesStatusList.add(value.get(i + 1));
			childNodeScreenShotList.add(value.get(i + 2));
			i = i + 3;

		}

	}

	public void extentReport() {

		ExtentTest parent = extent.startTest(test);
		parent.log(LogStatus.INFO, "Details are as below : ");
		for (int i = 0; i < childNodesList.size(); i++) {
			childNodesListFinal.add(extent.startTest(childNodesList.get(i)));

		}

		if (childNodesStatusList.size() == childNodesListFinal.size()) {
			for (int i = 0; i < childNodesStatusList.size(); i++) {
				if (childNodesStatusList.get(i).contains("Pass")) {
					childNodesListFinal.get(i).log(LogStatus.PASS, childNodesList.get(i),
							childNodesStatusInfoList.get(i));
					screenShotHTMLTag = childNodesListFinal.get(i).addScreenCapture(childNodeScreenShotList.get(i));
					childNodesListFinal.get(i).log(LogStatus.INFO, screenShotHTMLTag);
					System.out.println("childNodeScreenShotList.get(i)" + childNodeScreenShotList.get(i));

				}

				if (childNodesStatusList.get(i).equalsIgnoreCase("Fail")) {
					childNodesListFinal.get(i).log(LogStatus.FAIL, childNodesList.get(i),
							childNodesStatusInfoList.get(i));
					screenShotHTMLTag = childNodesListFinal.get(i).addScreenCapture(childNodeScreenShotList.get(i));
					childNodesListFinal.get(i).log(LogStatus.INFO, screenShotHTMLTag);
				}

				if (childNodesStatusList.get(i).contains("Unknown")) {

					childNodesListFinal.get(i).log(LogStatus.UNKNOWN, childNodesList.get(i),
							childNodesStatusInfoList.get(i));

				}

			}
		}

		else {

			System.out.println("childNodesListFinal and childNodesStatusList are of different sizes");
			System.out.println("childNodesListFinal elements : ");
			for (int i = 0; i < childNodesListFinal.size(); i++) {
				System.out.println(childNodesListFinal.get(i));

			}
			System.out.println("childNodesStatusList elements : ");
			for (int i = 0; i < childNodesListFinal.size(); i++) {
				System.out.println(childNodesListFinal.get(i));

			}

		}
		/*
		 * parent .appendChild(child1) .appendChild(child2);
		 * 
		 */

		for (int i = 0; i < childNodesListFinal.size(); i++) {
			parent.appendChild(childNodesListFinal.get(i));
		}

		/*
		 * String css =
		 * "body, .test .right span, .collapsible-header { background: #333; color: #fff; }"
		 * + "nav, .tab, .card-panel { background: #000 !important; }" +
		 * "table { border: 1px solid #555 !important; }" +
		 * "pre { background: #333; border: 1px solid #777 !important; color: #eee !important; }"
		 * +
		 * ".select-dropdown { background: #333; border-bottom: 1px solid #777 !important; }"
		 * +
		 * ".select-dropdown li:hover, .select-dropdown li.active { background: #555; }"
		 * +
		 * "table.bordered > thead > tr, table.bordered > tbody > tr, th, td { border-bottom: 1px solid #555 !important; }"
		 * +
		 * "th, td, .test-name, .test-desc, .test .right span { color: #fff !important; }"
		 * + ".test-body .collapsible > li { border: 1px solid #777; }";
		 * extent.config().insertCustomStyles(css);
		 */

		extent.config().reportName("Automation Report");
		extent.config().reportHeadline(": Regression Execution Report");
		parent = parent.assignCategory("PI1");
		extent.endTest(parent);
		extent.flush();
	}

}
