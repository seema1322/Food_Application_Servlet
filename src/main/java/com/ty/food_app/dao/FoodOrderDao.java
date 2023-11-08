package com.ty.food_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app.entity.FoodOrder;
import com.ty.food_app.entity.Item;
import com.ty.food_app.exceptions.FoodOrderNotFoundException;

public class FoodOrderDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveFoodOrder(FoodOrder foodOrder) {
		
		//List<Item> items= foodOrder.getItems();
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
	}
	
	public boolean deleteFoodOrder(int id) {
		
		FoodOrder foodOrder= entityManager.find(FoodOrder.class, id);
		
		if (foodOrder != null) {
			entityTransaction.begin();
			//foodOrder.setUser(null);
			List<Item> items= foodOrder.getItems();
			//foodOrder.setItems(null);
			
			for (Item item : items) {
				entityManager.remove(item);
			}
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		} else {
			throw new FoodOrderNotFoundException();
		}
	}
	
	public void updateFoodOrder(int orderId, String status) {
		FoodOrder foodOrder= entityManager.find(FoodOrder.class, orderId);
		
		if (foodOrder != null) {
			foodOrder.setStatus(status);
			
			entityTransaction.begin();
			entityManager.merge(foodOrder);
			entityTransaction.commit();
			
		} else {
			throw new FoodOrderNotFoundException();
		}
	}
	
	public List<FoodOrder> displayAllOrders(){
		
		Query query = entityManager.createQuery("select order from FoodOrder order");
		List<FoodOrder> orders= query.getResultList();
		
		if (orders != null) {
			return orders;
		}
		throw new FoodOrderNotFoundException();
	}
	
	public FoodOrder viewOrderById(int orderId) {
		FoodOrder foodOrder= entityManager.find(FoodOrder.class, orderId);
		
		if (foodOrder != null) {
			return foodOrder;
		}
		throw new FoodOrderNotFoundException();
	}
}

