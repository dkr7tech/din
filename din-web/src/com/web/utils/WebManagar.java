package com.web.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.common.utils.ObjectUtility;

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

}
