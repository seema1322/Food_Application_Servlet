package com.ty.food_app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food_app.entity.Branch;
import com.ty.food_app.exceptions.BranchNotFoundException;

public class BranchDao {
	private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Branch getBranchById(int branchId) {
		
		Branch branch= entityManager.find(Branch.class, branchId);
		
		if (branch != null) {
			return branch;
		}
		throw new BranchNotFoundException();
	}

}