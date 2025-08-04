package com.db;

import java.util.List;

import org.javers.spring.annotation.JaversAuditable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.user.User;
import com.model.user.UserPreference;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

	public UserDAOImpl() {
		
	}
	
	/*public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/

	
	@Transactional
	public List<User> list() {
		return entityManager.createQuery("select u from User u")
				.getResultList();
	}

	 @JaversAuditable
	@Transactional
	public User saveOrUpdate(User user) {
		 
		return entityManager.merge(user);
	}

	/*
	@Transactional
	public void saveOrUpdateRole(TtRole role) {
		entityManager.merge(role);
	}*/

	
	@Transactional
	public void delete(User user) {
		entityManager.remove(user);
	}

	
	@Transactional
	public User get(int id) {
		String hql = "from User where id=" + id;
		return entityManager.find(User.class, id);
			
		
		//return null;
	}

	
	public User getUser(String login, String password) {
		String hql="SELECT u FROM User u WHERE u.login = :login AND u.password = :password ";
		User user=null;
		List<User> userList =entityManager.createQuery(hql, User.class)
		.setParameter("login", login)
		.setParameter("password", password)
		.getResultList();
		if(userList!=null && !userList.isEmpty()){
			user=userList.get(0);	
		}else{
			System.out.println("UserDAOImpl getUser() no record for user "+login);
		}
		
		return user;
		
	}

	public User getUser(String userName) {

		String hql="SELECT u FROM User u WHERE u.login = :login ";
		User user=null;
		List<User> userList =entityManager.createQuery(hql, User.class)
		.setParameter("login", userName)
		
		.getResultList();
		if(userList!=null && !userList.isEmpty()){
			user=userList.get(0);	
		}else{
			System.out.println("UserDAOImpl getUser() no record for user "+userName);
		}
		
		return user;
		
	}

	@Override
	@Transactional
	public UserPreference saveUserPref(UserPreference preference) {
		
		return  entityManager.merge(preference);
	}
}