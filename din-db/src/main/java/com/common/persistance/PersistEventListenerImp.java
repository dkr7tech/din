package com.common.persistance;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistContext;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;

public class PersistEventListenerImp implements PersistEventListener {
 
   private static final long serialVersionUID = 1L;
   public static final PersistEventListenerImp INSTANCE = new PersistEventListenerImp();
@Override
public void onPersist(PersistEvent event) throws HibernateException {
	System.out.println("PersistEventListenerImp1");
	
}
@Override
public void onPersist(PersistEvent event, PersistContext createdAlready) throws HibernateException {
	System.out.println("PersistEventListenerImp2");
	
}


   
   
   }