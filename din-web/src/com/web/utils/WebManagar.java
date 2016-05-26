package com.web.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.common.utils.ObjectUtility;
import com.config.web.WebConstants;

public class WebManagar {
	static final org.apache.log4j.Logger log = Logger.getLogger(WebManagar.class);
	
	public static HttpSession  generateNewSessionId(HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug(" INSIDE  METHOD:generateNewSessionId ");
		}
		HttpSession httpSession=null;
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		// copy all attributes
		httpSession = request.getSession(false);
		String name="";
		if (ObjectUtility.isNull(httpSession)) {
			httpSession = request.getSession(true);
		} else {
			Enumeration<String> enames = httpSession.getAttributeNames();
			while (enames.hasMoreElements()) {
				name = enames.nextElement();
				if (!name.equals("JSESSIONID")) {
					attributes.put(name, httpSession.getAttribute(name));
				}
			}
			httpSession.invalidate();
			httpSession =  request.getSession(true);
			// "restore" the session values
			for (Map.Entry<String, Object> et : attributes.entrySet()) {
				httpSession.setAttribute(et.getKey(), et.getValue());
			}
		}
		if (log.isDebugEnabled()) {
			log.debug(" LEAVING METHOD:generateNewSessionId ");
		}
		return httpSession;
	}
	
	public HttpSession getNewSessionObject(HttpServletRequest request){
	HttpSession session=request.getSession();
	
	if(session.isNew()){
        System.out.println("New session created by default");
        request.getSession(true);
       String sessionID = session.getId();
        
    }else{
        System.out.println("You have created a new session");
        request.getSession().invalidate();
        request.getSession(true);
      
     }
	return session;	
	}
	public static void setApplicationProperties(ServletContext servletContext) {
		System.out.println("set appliation properties called");
		WebUtil util = new WebUtil(servletContext);
		Map<String, String> propertiesMap = PropertyManager.readPropertiefiles(WebConstants.RESOURCE_PROP_FILE);
		String contextPath = servletContext.getContextPath();
		ContextData contextData = new ContextData();
		contextData.setExtJSPath(contextPath + propertiesMap.get(WebConstants.EXT_JS_PATH).trim());
		contextData.setOpenLayerJsPath(contextPath + propertiesMap.get(WebConstants.OPENLAYER_JS_PATH).trim());
		contextData.setContextPath(contextPath);
		contextData.setCustomJsPath(contextPath + propertiesMap.get(WebConstants.CUSTOM_JS_PATH).trim());
		contextData.setImagesPath(contextPath + propertiesMap.get(WebConstants.IMAGES_PATH).trim());
		contextData.setCssPath(contextPath + propertiesMap.get(WebConstants.CSS_PATH).trim());
		contextData.setJqueryJsPath(contextPath + propertiesMap.get(WebConstants.JQUERY_PATH).trim());
		contextData.setProductionEnv(Boolean.parseBoolean(propertiesMap.get(WebConstants.DEVELOPMENT_ENV).trim()));
		contextData.setSpringLibJspPath(propertiesMap.get(WebConstants.SPRING_LIB_JSP_PATH).trim());
		contextData.setJstlJspPath(propertiesMap.get(WebConstants.JSTL_LIB_JSP_PATH).trim());
		contextData.setScriptJspPath(propertiesMap.get(WebConstants.SCRIPT_JSP_PATH).trim());
		contextData.setLoginURL(propertiesMap.get(WebConstants.LOGIN_URL).trim());
		servletContext.setAttribute(WebConstants.APP_CONTEXT_DATA, contextData);

	}
}
