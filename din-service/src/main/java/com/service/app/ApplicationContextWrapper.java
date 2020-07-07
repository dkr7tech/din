package com.service.app;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.db.AuditorImpl;



@Service
class ApplicationContextWrapper {

    private static ApplicationContext context;

    @Autowired
    public ApplicationContextWrapper(ApplicationContext ac) {
        setContext(ac);
    }

    public static ApplicationContext getContext() {
        return context;
    }

	public static void setContext(ApplicationContext context) {
		ApplicationContextWrapper.context = context;
		System.out.println("ApplicationContextWrapper"+context);
		//AuditorImpl.INSTANCE.setEntityManager(context.getBean(EntityManager.class));
	}
	@Bean
	public ApplicationListener<ContextRefreshedEvent> applicationListener() {
	    
	    return new ApplicationListener<ContextRefreshedEvent>() {
	        public void onApplicationEvent(ContextRefreshedEvent event) {
	        	System.out.println("ApplicationContextWrappe  onApplicationEventr"+context);
	        	EntityManager manager=event.getApplicationContext().getBean(EntityManager.class);
	        	
	    		//AuditorImpl.INSTANCE.setEntityManager(manager);
	    		//AuditorImpl.INSTANCE.setEntityManager(context.getBean(EntityManager.class));
	        	//getContext().setApplicationContext(event.getApplicationContext());
	        }
	    };
	}

}