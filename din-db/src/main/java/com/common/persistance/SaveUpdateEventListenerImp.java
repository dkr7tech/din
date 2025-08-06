package com.common.persistance;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistContext;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;

public class SaveUpdateEventListenerImp implements PersistEventListener {

   public static final SaveUpdateEventListenerImp INSTANCE = new SaveUpdateEventListenerImp();





   @Override
   public void onPersist(PersistEvent event) throws HibernateException {

	      Object obj = event.getObject();
	     System.out.println("SaveUpdateEventListenerImp"+obj.getClass());
	
   }


   @Override
   public void onPersist(PersistEvent event, PersistContext createdAlready) throws HibernateException {
	// TODO Auto-generated method stub
	
   }
   
   }