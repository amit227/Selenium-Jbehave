

package com.relevantcodes.extentreports.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
	
	public static Matcher getMatch(String line, String pattern) {
	      Pattern p = Pattern.compile(pattern);
	      Matcher m = p.matcher(line);
	      
	      if (m.find()) {
	    	  return m;
	      }
	      
	      return null;
	}
	
	public static String getNthMatch(String line, String pattern, Integer n) {
		try {
			return getMatch(line, pattern).group(n);
		}
		catch (Exception e) {
			return null;
		}
	}
}
