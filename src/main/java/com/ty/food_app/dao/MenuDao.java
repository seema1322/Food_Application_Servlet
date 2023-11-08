package com.ty.food_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_app.entity.Menu;
import com.ty.food_app.exceptions.MenuNotFoundException;

public class MenuDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seema");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void addMenu(Menu menu) {

		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
	}

	public Menu getMenu() {
		Query query= entityManager.createQuery("select m from Menu m");
		List<Menu> menu = query.getResultList();

		if (menu != null) {
			for (Menu menu2 : menu) {
				if (menu2 !=null) {
					return menu2;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public void updateMenu(Menu menu) {

		Menu menu1 = entityManager.find(Menu.class, menu.getId());

		menu1.setFoodProducts(menu.getFoodProducts());
		entityTransaction.begin();
		entityManager.persist(menu1);
		entityTransaction.commit();

	}

}
