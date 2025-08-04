package com.config.web;



import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.IntegrationConfigurer;
import com.config.PersistenceJPAConfig;
import com.config.SpringAppComponentConfig;
import com.web.servlet.AppConfigServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

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

	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		 System.err.println("------------------------------------");
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
        .addMappingForUrlPatterns(DispatcherType.REQUEST, true, "/secured","","/");*
        
	}*/
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.err.println("---- Initializing Spring Web Application ----");

        // Root Spring context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(
                PersistenceJPAConfig.class,
                IntegrationConfigurer.class,
                SpringAppComponentConfig.class,
                SpringWebComponentConfigration.class
        );
        context.setServletContext(servletContext);

        // Dispatcher servlet registration
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/"); // Use path-based mapping for Spring MVC

        // Additional custom servlet (optional)
        ServletRegistration.Dynamic appConfigServlet = servletContext.addServlet("AppConfigServlet", new AppConfigServlet());
        appConfigServlet.setLoadOnStartup(1); // Optional if needed
        appConfigServlet.addMapping("/conf/AppConfigServlet");

        // Session Authentication Filter registration
        //FilterRegistration.Dynamic sessionFilter = servletContext.addFilter("SessionAuthenticationFilter", SessionAuthenticationFilter.class);
        //sessionFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "*.htm"); // Only filter .htm URLs
    }
}