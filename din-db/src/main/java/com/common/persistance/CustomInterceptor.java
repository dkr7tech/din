package com.common.persistance;


import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.Entity;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;



public class CustomInterceptor extends EmptyInterceptor {
    

    /**
	 * 
	 */
	private static final long serialVersionUID = -7110992028915496159L;


   
    
    @Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
    	boolean bool=super.onSave(entity, id, state, propertyNames, types);
		System.out.println("$$$$$$$$$$$$$$  CustomInterceptor onSave"+entity.getClass());
		//PersistentManager.INSTANCE.doAudit(entity);
        return bool;
	}

	@Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object [] previousState, String[] propertyNames, Type[] types) {
		System.out.println("$$$$$$$$$$$$$$  CustomInterceptor onFlushDirty");
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		boolean bool=super.onLoad(entity, id, state, propertyNames, types);
		return bool;
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		 System.out.println("$$$$$$$$$$$$$$  CustomInterceptor afterTransactionCompletion");
		// TODO Auto-generated method stub
		 
		super.afterTransactionCompletion(tx);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		System.out.println("$$$$$$$$$$$$$$  CustomInterceptor findDirty");
		return super.findDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public void preFlush(Iterator entities) {
		if(entities.hasNext()) {
		
		//PersistentManager.INSTANCE.doAudit(entities.next());
		}
		 System.out.println("$$$$$$$$$$$$$$  CustomInterceptor preFlush"+entities.getClass().getSimpleName());
		super.preFlush(entities);
	}
    
    
}