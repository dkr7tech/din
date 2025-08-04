package com.web.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class CustomDispatcher
 */

public class CustomDispatcher extends DispatcherServlet  {
	
	
	public CustomDispatcher(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

    
   /* @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    	System.out.println("########### CustomDispatcher Servlet initialized  #######################" );
        super.init(config);
    	WebManagar.setApplicationProperties(this.getServletContext());
    }*/
    
   /* @Override
    protected WebApplicationContext initWebApplicationContext()
            throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("In suresh dispatcher servlet WebApplicationContext method");
    
        WebApplicationContext wac = super.initWebApplicationContext();
        if(null!=wac){
        System.out.println("WAC Display Name " + wac.getDisplayName());
        String[] beanNames = wac.getBeanDefinitionNames();
        for(String bean:beanNames){
        System.out.println(" bean names " + bean) ;
        }
        }else{
            
            System.out.println("Web Application context is null ") ;
        }
        return wac;
    }
	*//**
	 * @see Servlet#destroy()
	 *//*
	public void destroy() {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	

}
