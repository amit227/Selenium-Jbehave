

package com.relevantcodes.extentreports;

import java.util.Map;

import com.relevantcodes.extentreports.source.ExtentFlag;
import com.relevantcodes.extentreports.source.SystemInfoHtml;
import com.relevantcodes.extentreports.support.RegexMatcher;

class SourceBuilder {
    public static String buildRegex(String source, String[] flags, String[] values) {
        for (int ix = 0; ix < flags.length; ix++) {
            
            String matcher = flags[ix] + ".*" + flags[ix];
            String match = RegexMatcher.getNthMatch(source, matcher, 0);
            
            if (match == null) {
                source = source.replace(flags[ix], values[ix]);
            }
            else {                
                source = source.replace(match, matcher.replace(".*", values[ix]));
            }
        }
        
        return source;
    }
    
    public static String build(String source, String[] flags, String[] values) {
        for (int ix = 0; ix < flags.length; ix++) {            
            source = source.replace(flags[ix], values[ix]);
        }
        
        return source;
    }
    
    public static String getSource(Map<String, String> info) {
        String src = "";
        
        for (Map.Entry<String, String> entry : info.entrySet()) {
            src += SystemInfoHtml.getColumn();
            
            src = src.replace(ExtentFlag.getPlaceHolder("systemInfoParam"), entry.getKey())
                        .replace(ExtentFlag.getPlaceHolder("systemInfoValue"), entry.getValue());
        }
        
        return src;
    }
}
