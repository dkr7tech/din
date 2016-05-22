package com.config.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.PersistenceJPAConfig;
import com.config.SpringAppComponentConfig;
import com.web.servlet.AppConfigServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(PersistenceJPAConfig.class,SpringAppComponentConfig.class,SpringWebComponentConfigration.class);
       // appContext.scan(basePackages);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/");
        ServletRegistration.Dynamic appconfigServlet=servletContext.addServlet("AppConfigServlet", new AppConfigServlet());
        appconfigServlet.addMapping("/AppConfigServlet");
        dispatcher.setLoadOnStartup(1);
        
	}
	
	

}