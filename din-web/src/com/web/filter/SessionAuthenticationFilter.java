package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.common.constant.CommonConstant;

/**
 * Servlet Filter implementation class SessionAuthenticationFilter
 */
@WebFilter("/*")
public class SessionAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	 @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
	        HttpServletRequest request = (HttpServletRequest) req;
	        
	        HttpServletResponse response = (HttpServletResponse) res;
	        HttpSession session = request.getSession(false);
	        //String loginURI = request.getContextPath() + "/login";
	        ServletContext context= request.getServletContext();
	       /* ContextData contextData=null;
	        if(context.getAttribute(CommonConstant.USER_SESSION)!=null){
	        	contextData=(ContextData)context.getAttribute(WebConstants.APP_CONTEXT_DATA);
	        }*/
	        String loginURI = request.getContextPath() + "/logon.htm";
	        System.out.println("filter request uri"+request.getRequestURI());
	        boolean loggedIn = session != null && session.getAttribute(CommonConstant.USER_SESSION) != null;
	        boolean loginRequest = request.getRequestURI().equals(loginURI);
	       // loggedIn=true;
	        if (loggedIn || loginRequest) {
	            chain.doFilter(request, response);
	        } else {
	            response.sendRedirect(loginURI);
	        }
	    }


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
