package com.web.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import com.web.utils.ContextData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.utils.ObjectUtility;
import com.config.web.WebConstants;
import com.model.common.LoginSessionBean;
import com.model.common.constant.CommonConstant;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class WebManagar extends WebConstants{
	static final Logger log = LoggerFactory.getLogger(WebManagar.class);
	
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
				if (!name.equals(JSESSIONID)) {
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

	public static LoginSessionBean getSessionBean(HttpServletRequest request) {
		LoginSessionBean loginSessionBean = null;
		if (request != null && request.getSession() != null
				&& request.getSession().getAttribute(CommonConstant.USER_SESSION) != null)
			loginSessionBean = (LoginSessionBean) request.getSession().getAttribute(CommonConstant.USER_SESSION);
		return loginSessionBean;

	}
	
	
	public void setUserSession(HttpSession session) {
		if(session!=null) {
		session.setAttribute(WebConstants.DATEFORMAT,"");
        session.setAttribute(WebConstants.TIME_FORMAT,"");
        session.setAttribute(WebConstants.DATE_TIME_FORMAT,"");
        session.setAttribute(WebConstants.NUMBER_FORMAT,"");
        session.setAttribute(WebConstants.PERCENTAGE_FORMAT,"");
        session.setAttribute(WebConstants.CURRENCY_NUMBER_FORMAT,"");
        session.setAttribute(WebConstants.TIME_ZONE,"");
        session.setAttribute(WebConstants.CLIENT_TIME_ZONE,"");
		}
	}
	public static void setApplicationProperties(ServletContext servletContext) {
		log.debug(" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^INSIDE  METHOD:generateNewSessionId ");
		log.info(" INSIDE  METHOD:generateNewSessionId %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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
		contextData.setAngularJsPath(contextPath + propertiesMap.get(WebConstants.ANGULARJS_PATH).trim());
		contextData.setProductionEnv(Boolean.parseBoolean(propertiesMap.get(WebConstants.DEVELOPMENT_ENV).trim()));
		contextData.setSpringLibJspPath(propertiesMap.get(WebConstants.SPRING_LIB_JSP_PATH).trim());
		contextData.setJstlJspPath(propertiesMap.get(WebConstants.JSTL_LIB_JSP_PATH).trim());
		contextData.setScriptJspPath(propertiesMap.get(WebConstants.SCRIPT_JSP_PATH).trim());
		contextData.setLoginPageURL(propertiesMap.get(WebConstants.LOGIN_URL).trim());
		contextData.setLoginReqURL(propertiesMap.get(WebConstants.LOGIN_REQ_URL).trim());
		contextData.setHomePageURL(propertiesMap.get(WebConstants.HOME_URL).trim());
		contextData.setJsPath(contextPath + propertiesMap.get(WebConstants.JS_PATH).trim());
		contextData.setBootstrapJsPath(contextPath + propertiesMap.get(WebConstants.BOOTSTRAP_JS).trim());
		contextData.setPopperJsPath(contextPath + propertiesMap.get(WebConstants.POPPER_JS).trim());
		servletContext.setAttribute(WebConstants.APP_CONTEXT_DATA, contextData);

	}
}
