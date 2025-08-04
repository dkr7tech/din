package com.common.persistance;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.common.audit.Action;
import com.common.audit.Audit;
import com.db.AuditorImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersistentManager {
	static Set<Class<?>> auditableClasses = null;
	public static final PersistentManager INSTANCE = new PersistentManager();
	static {
		Reflections reflections = new Reflections("com.model");
		auditableClasses = reflections.getTypesAnnotatedWith(Audit.class);
	}
	@PersistenceContext
	EntityManager entityManager;

	public PersistentManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Set<Class<?>> getAuditableClasses() {
		return auditableClasses;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public PersistentManager(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public static void main(String[] args) {
		Reflections reflections = new Reflections("com.model");
		Set<Class<?>> challengeClasses = reflections.getTypesAnnotatedWith(Audit.class);
		Map challengeClassesMap = challengeClasses.stream()
				.collect(Collectors.toMap(challengeClass -> challengeClass.getAnnotation(Audit.class).value(),
						PersistentManager::createNewInstanceOfClass));

		System.out.println("Hello World!");

		challengeClassesMap.forEach((key, value) -> {
			System.out.println(key + " = " + value.toString());
			// TestAnno an = (TestAnno) value;
			// an.print();
			challengeClasses.forEach(auditable -> {
				AuditorImpl auditorImpl = new AuditorImpl();
				//auditorImpl.doAudit(auditable);
			});

			// value.print();
		});

	}

	private static <T> T createNewInstanceOfClass(Class<T> someClass) {
		try {
			return someClass.newInstance();
		} catch (Exception e) {
			return null; // Bad idea but now it's waste of time
		}
	}

	public void merge(Object object) {
		getEntityManager().merge(object);
		
		doAudit(object);

	}

	public void doAudit(Object object) {
		AuditorImpl auditor = AuditorImpl.INSTANCE;
		auditor.setEntityManager(entityManager);
		if (auditableClasses.contains(object.getClass())) {
			auditor.doAudit(Action.UPDATE,object);
		}
	}

	private void set() {
		Reflections reflections = new Reflections("com.model");
		auditableClasses = reflections.getTypesAnnotatedWith(Audit.class);

	}
}
