

package com.relevantcodes.extentreports.support;

import java.io.InputStream;

public class Resources extends ClassLoader {
	public static String getText(String resourcePath) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//String path=classLoader.findResource//("STANDARD.min.html").toString();
		InputStream input = classLoader.getResourceAsStream(resourcePath);
		
		
  		return Stream.toString(input);
	}
}
