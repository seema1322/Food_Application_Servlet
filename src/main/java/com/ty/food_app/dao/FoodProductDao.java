package com.ty.food_app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food_app.entity.FoodProducts;

public class FoodProductDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodProducts findFoodProductById(int id) {

		FoodProducts foodProduct = entityManager.find(FoodProducts.class, id);

		if (foodProduct != null) {
			return foodProduct;
		} else {
			return null;
		}
	}

	public boolean deleteFoodProduct(int id) {

		FoodProducts foodProduct = entityManager.find(FoodProducts.class, id);

		if (foodProduct != null) {
			foodProduct.setMenu(null);
			entityTransaction.begin();
			entityManager.remove(foodProduct);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
