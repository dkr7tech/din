package com.model.common;

import static com.common.audit.Action.CREATE;
import static com.common.audit.Action.DELETE;
import static com.common.audit.Action.LOAD;
import static com.common.audit.Action.UPDATE;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
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

	   @Transactional(TxType.MANDATORY)
    private void perform(Object target, Action action) {
        System.out.println("Performing audit action " + action + " on " + target);
        // Note: Cannot inject EntityManager here reliably.
        // Instead, delegate this operation to a CDI/Spring-managed bean or service.
        // Example:
        // Audit
}

}
