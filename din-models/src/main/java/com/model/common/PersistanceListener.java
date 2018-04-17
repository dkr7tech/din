package com.model.common;

import static com.common.audit.Action.CREATE;
import static com.common.audit.Action.DELETE;
import static com.common.audit.Action.UPDATE;
import static com.common.audit.Action.LOAD;
import static javax.transaction.Transactional.TxType.MANDATORY;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import com.common.audit.Action;

/*
 * 
 JPA specifies seven optional lifecycle events that are called:

    before persist is called for a new entity – @PrePersist
    after persist is called for a new entity – @PostPersist
    before an entity is removed – @PreRemove
    after an entity has been deleted – @PostRemove
    before the update operation – @PreUpdate
    after an entity is updated – @PostUpdate
    after an entity has been loaded – @PostLoad

 * *
 */

public class PersistanceListener {

	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PrePersist
	public void prePersist(Object target) {
		System.out.println("inside PersistanceListener prePersist");
		perform(target, CREATE);
	}

	@PostPersist
	public void postPersist(Object target) {
		System.out.println("inside PersistanceListener postPersist");
		perform(target, CREATE);
	}

	@PreUpdate
	public void preUpdate(Object target) {

		System.out.println("inside PersistanceListener preUpdate");
		perform(target, UPDATE);
	}

	@PostUpdate
	public void postUpdate(Object target) {

		System.out.println("inside PersistanceListener postUpdate");
		perform(target, UPDATE);
	}

	@PreRemove
	public void preRemove(Object target) {
		System.out.println("inside PersistanceListener preRemove");
		perform(target, DELETE);
	}

	@PostLoad
	public void postLoad(Object target) {

		System.out.println("inside PersistanceListener postLoad");
		perform(target, LOAD);
	}

	@Transactional(MANDATORY)
	private void perform(Object target, Action action) {
		System.out.println("inside PersistanceListener " + entityManager);
		// entityManager.persist(new FileHistory(target, action));
	}

}
