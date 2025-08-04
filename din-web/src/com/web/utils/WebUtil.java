package com.web.utils;

import java.util.HashMap;

import jakarta.servlet.ServletContext;



public class WebUtil {
private static  String contextPath=null;
private static String configPath=null;
private static ServletContext servletContext=null;

public WebUtil(ServletContext context) {
	servletContext=context;
	contextPath=context.getContextPath();
	configPath="/WEB-INF/config/";
}

public static ServletContext getServletContext() {
	return servletContext;
}

public static String getContextPath() {
	return contextPath;
}

public static String getConfigPath() {
	return configPath;
}

public static void setApplicationProperties(ServletContext servletContext) {

	WebUtil util = new WebUtil(servletContext);
	System.out
			.println(servletContext.getRealPath("/WEB-INF/conf/")
					+ "set appliation properties called"
					+ WebUtil.getContextPath());
	HashMap<String, String> cofigMap = new HashMap<String, String>();
	cofigMap.put("EXT_JS_PATH", WebUtil.getContextPath() + "/js/ext-3.2.1");
	cofigMap.put("OPENLAYER_JS_PATH", WebUtil.getContextPath()
			+ "/js/Map/OpenLayers-2.9.1");
	cofigMap.put("IMAGE_PATH", WebUtil.getContextPath() + "/image");
	cofigMap.put("JS_PATH", WebUtil.getContextPath() + "/js");
	cofigMap.put("COFIG_FILES_PATH", WebUtil.getConfigPath());
	servletContext.setAttribute("configMap", cofigMap);

}

}
