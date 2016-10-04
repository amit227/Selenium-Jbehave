package com.bdd.test.jbehave.io;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportParams {

	public static List<String> childNodesStatusList = new ArrayList<String>();
	public static List<String> childNodesStatusInfoList = new ArrayList<String>();
	public static List<String> childNodesDescriptionList = new ArrayList<String>();
	public static List<String> childNodesVALUESList = new ArrayList<String>();
	public static Map<String, List<String>> childInfoMap = new LinkedHashMap<String, List<String>>();
	public static String PASS = "Pass";
	public static String FAIL = "Fail";
	public static String UNKNOWN = "Unknown";
	public static Boolean status = null;
	public static List<String> screenShotPathList = null;
	/*
	 * this method must be called before first step of a Scenario, and this can
	 * be called only once per scenario
	 */

	public static void clearAndInitializeParams() {

		childNodesStatusList = null;
		childNodesStatusInfoList = null;
		childNodesDescriptionList = null;
		screenShotPathList = new ArrayList<String>();
		childNodesVALUESList = null;

		childNodesStatusList = new ArrayList<String>();
		childNodesStatusInfoList = new ArrayList<String>();
		childNodesDescriptionList = new ArrayList<String>();
		childNodesVALUESList = new ArrayList<String>();
		childInfoMap = new LinkedHashMap<String, List<String>>();

	}

	public static void reportChildParams(String stepName, String statusInfo, String status, String screenShotPath) {

		childNodesDescriptionList.add(stepName);
		childNodesStatusInfoList.add(statusInfo);
		childNodesStatusList.add(status);
		screenShotPathList.add(screenShotPath);
		int i = childNodesStatusInfoList.size() - 1;
		int j = childNodesStatusList.size() - 1;
		int k =	screenShotPathList.size()-1;
		int l = childNodesDescriptionList.size() - 1;
		
		childNodesVALUESList.add(childNodesStatusInfoList.get(i));
		childNodesVALUESList.add(childNodesStatusList.get(j));
		childNodesVALUESList.add(screenShotPathList.get(k));

		childInfoMap.put(childNodesDescriptionList.get(l), childNodesVALUESList);

	}

}
