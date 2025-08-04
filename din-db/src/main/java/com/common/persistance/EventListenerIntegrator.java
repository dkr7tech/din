package com.common.persistance;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.common.persistance.CustomStrategy;
import com.common.persistance.SaveUpdateEventListenerImp;
import com.common.persistance.PersistEventListenerImp;
import com.common.persistance.MergeEventListenerImpl;

public class EventListenerIntegrator implements Integrator {
	public static final EventListenerIntegrator INSTANCE = new EventListenerIntegrator();

	@Override
	public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		EventListenerRegistry eventListenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
		  eventListenerRegistry.addDuplicationStrategy( CustomStrategy.INSTANCE );
		eventListenerRegistry.getEventListenerGroup(EventType.SAVE_UPDATE).appendListener(SaveUpdateEventListenerImp.INSTANCE);
		eventListenerRegistry.getEventListenerGroup(EventType.PERSIST).appendListener(PersistEventListenerImp.INSTANCE);
		eventListenerRegistry.getEventListenerGroup(EventType.MERGE).appendListener(MergeEventListenerImpl.INSTANCE);
		/*eventListenerRegistry.prependListeners( EventType.MERGE,MergeEventListenerImpl.class);
		eventListenerRegistry.prependListeners( EventType.PERSIST,PersistEventListenerImp.class);
		eventListenerRegistry.prependListeners( EventType.SAVE_UPDATE,SaveUpdateEventListenerImp.class);*/
		
		
		
		System.out.println("EventListenerIntegrator");

	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

	}

}