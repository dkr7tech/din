package com.config;
/*
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.common.persistance.MergeEventListenerImpl;
import com.common.persistance.SaveUpdateEventListenerImp;

@Configuration
public class HibernateListenerConfigurer {
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Autowired
	private MergeEventListenerImpl mergeEventListener;

	@PostConstruct
	protected void init() {
		SessionFactoryImpl sessionFactory = emf.unwrap(SessionFactoryImpl.class);
		EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
		registry.getEventListenerGroup(EventType.MERGE).appendListener(mergeEventListener.INSTANCE);
		System.out.println("HibernateListenerConfigurer$$$$$$$$$$$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%5");
	}

}
*/