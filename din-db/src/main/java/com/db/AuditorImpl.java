package com.db;



import com.common.audit.Action;
import com.common.audit.Auditor;

import jakarta.persistence.EntityManager;

public class AuditorImpl implements Auditor{
	public static final AuditorImpl INSTANCE = new AuditorImpl();
	
	EntityManager entityManager;

	public AuditorImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	public void doAudit(Action action,Object object) {
		System.out.println("@@@@@@@@@@@@@@  audit"+object.getClass());
		AuditData audit=new AuditData();
		audit.setAction(action!=null ?action.getActionType():Action.CREATE.getActionType());
		audit.setTransactionId(object.getClass().getName());
		audit.setEntityType(object.getClass().getName());
		//audit.setTransactionId(getEntityManager().getTransaction().toString());
		
		getEntityManager().persist(audit);
	}

}
