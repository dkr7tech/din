package com.common.persistance;


import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;


public class SaveUpdateEventListenerImp implements SaveOrUpdateEventListener {
 
   private static final long serialVersionUID = 1L;
   public static final SaveUpdateEventListenerImp INSTANCE = new SaveUpdateEventListenerImp();


   @Override
   public void onSaveOrUpdate(SaveOrUpdateEvent e) throws HibernateException {

     

      Object obj = e.getEntity();
     System.out.println("SaveUpdateEventListenerImp"+obj.getClass());
   }
   
   }