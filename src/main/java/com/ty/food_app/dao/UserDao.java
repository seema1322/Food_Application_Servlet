package com.ty.food_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app.entity.Branch;
import com.ty.food_app.entity.FoodOrder;
import com.ty.food_app.entity.User;
import com.ty.food_app.exceptions.UserNotFoundException;

public class UserDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public User addBranchManager(User user) {

		List<Branch> branch = user.getBranch();

		entityTransaction.begin();
		for (Branch branch2 : branch) {
			entityManager.persist(branch2);
		}
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User addEmployee(User user) {

		// List<Branch> branch = user.getBranch();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User findUserByPhone(long phone) {

		Query query = entityManager.createQuery("select u from User u where u.phone=?1");
		query.setParameter(1, phone);

		User user = (User) query.getSingleResult();

		if (user != null) {
			return user;
		}
		throw new UserNotFoundException();
	}

	public User findUserByPhonePassword(long phone, String password) {

		Query query = entityManager.createQuery("select u from User u where u.phone=?1");
		query.setParameter(1, phone);

		User user = (User) query.getSingleResult();

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		throw new UserNotFoundException();

	}

	public void updateUser(User user) {

		Query query = entityManager.createQuery("select u from User u where u.phone=?1");
		query.setParameter(1, user.getPhone());
		
		User user1 = (User) query.getSingleResult();
		if (user1 != null) {
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
		} else {
			throw new UserNotFoundException();
		}
	}

	public void deleteUser(long phone) {

		Query query = entityManager.createQuery("select u from User u where u.phone=?1");
		query.setParameter(1, phone);
		
		User user1 = (User) query.getSingleResult();
		
		if (user1 != null && user1.getRole().equalsIgnoreCase("employee")) {
			entityTransaction.begin();
			entityManager.remove(user1);
			entityTransaction.commit();
		}
	}

	public List<User> displayAllEmployee() {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, "Employee");
		List<User> employees = query.getResultList();

		if (employees != null) {
			return employees;
		}
		return null;
	}
	
	public List<User> displayAllCustomer() {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, "Customer");
		List<User> employees = query.getResultList();

		if (employees != null) {
			return employees;
		}
		return null;
	}
	
	public User manager() {
		Query query = entityManager.createQuery("select u from User u");
		List<User> employees = query.getResultList();

		if (employees != null) {
			for (User user : employees) {
				if (user.getRole().equalsIgnoreCase("manager")) {
					return user;
				}
			}
		}
		return null;
	}
}

