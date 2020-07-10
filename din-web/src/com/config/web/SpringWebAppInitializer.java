package com.config.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.IntegrationConfigurer;
import com.config.PersistenceJPAConfig;
import com.config.SpringAppComponentConfig;
import com.web.filter.SessionAuthenticationFilter;
import com.web.servlet.AppConfigServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {
	
	/*http://kielczewski.eu/2013/11/spring-mvc-without-web-xml-using-webapplicationinitializer/
*/	/* @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        WebApplicationContext context = getContext();
	        servletContext.addListener(new ContextLoaderListener(context));
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	        ServletRegistration.Dynamic appconfigServlet=servletContext.addServlet("AppConfigServlet", new AppConfigServlet());
	        appconfigServlet.addMapping("/AppConfigServlet");
	        dispatcher.setLoadOnStartup(1);
	    }

	    private AnnotationConfigWebApplicationContext getContext() {
	    	   AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	           appContext.register(PersistenceJPAConfig.class,SpringAppComponentConfig.class,SpringWebComponentConfigration.class);
	         return appContext;
	    }*/

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(PersistenceJPAConfig.class,IntegrationConfigurer.class,SpringAppComponentConfig.class,SpringWebComponentConfigration.class);
       // appContext.scan(basePackages);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/");
        ServletRegistration.Dynamic appconfigServlet=servletContext.addServlet("AppConfigServlet", new AppConfigServlet());
        //appconfigServlet.addMapping("/AppConfigServlet");
        dispatcher.setLoadOnStartup(1);
        
        servletContext.addFilter("SessionAuthenticationFilter", SessionAuthenticationFilter.class);
       
      /*  servletContext.getFilterRegistration("SessionAuthenticationFilter")
        .addMappingForUrlPatterns(DispatcherType.REQUEST, true, "/secured","","/");*/
        
	}
}