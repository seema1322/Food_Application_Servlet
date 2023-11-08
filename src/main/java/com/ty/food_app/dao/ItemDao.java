package com.ty.food_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app.entity.Item;
import com.ty.food_app.exceptions.ItemNotFoundException;


public class ItemDao {
	
	private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Item saveItem(Item item) {
		
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		
		return item;
	}
	
	public boolean deleteItem(Item item) {
		
		if (entityManager.find(Item.class, item.getId())!=null) {

			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		throw new ItemNotFoundException();
		
	}
	
	public Item updateItem(Item item) {
		
		Item item1=entityManager.find(Item.class, item.getId());
		
		if (item1!=null) {
			
			item1.setPrice(item.getPrice());
			item1.setQuantity(item.getQuantity());
			
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			return item1;
		}
		throw new ItemNotFoundException();
		
	}
	
	public List<Item> displayAllItems(){
		
		Query query= entityManager.createQuery("select i from Item i");
		
		List<Item> items= query.getResultList();
		if (items != null) {
			return items;
		}
		throw new ItemNotFoundException();
	}
	
	
	public Item findItemById(int itemId) {
		Item item=entityManager.find(Item.class, itemId);
		
		if (item != null) {
			return item;
		}
		throw new ItemNotFoundException();
	}

}
