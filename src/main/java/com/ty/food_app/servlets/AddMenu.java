package com.ty.food_app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.food_app.dao.MenuDao;
import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.FoodProducts;
import com.ty.food_app.entity.Menu;
import com.ty.food_app.entity.User;

@WebServlet(value = "/addmenu")
public class AddMenu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MenuDao menuDao = new MenuDao();
		UserDao userDao= new UserDao();
		
		User user = userDao.manager();

		Menu menu = menuDao.getMenu();
		if (menu == null) {
			menu= new Menu();
			//PrintWriter printWriter = resp.getWriter();
			List<FoodProducts> list = new ArrayList<>();
			
			String name = req.getParameter("Name");
			String type = req.getParameter("Type");
			String about = req.getParameter("About");
			String availability = req.getParameter("Avail");
			double price = Double.parseDouble(req.getParameter("Price"));

			FoodProducts foodProducts = new FoodProducts();
			foodProducts.setName(name);
			foodProducts.setType(type);
			foodProducts.setAbout(about);
			foodProducts.setAvailability(availability);
			foodProducts.setPrice(price);
			foodProducts.setMenu(menu);

			list.add(foodProducts);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddMenu.jsp");
			requestDispatcher.include(req, resp);

			menu.setFoodProducts(list);
			menu.setUser(user);
			user.setMenu(menu);

			menuDao.addMenu(menu);
		} else {
			//PrintWriter printWriter = resp.getWriter();
			List<FoodProducts> list = new ArrayList<>();
			
			String name = req.getParameter("Name");
			String type = req.getParameter("Type");
			String about = req.getParameter("About");
			String availability = req.getParameter("Avail");
			double price = Double.parseDouble(req.getParameter("Price"));

			FoodProducts foodProducts = new FoodProducts();
			foodProducts.setName(name);
			foodProducts.setType(type);
			foodProducts.setAbout(about);
			foodProducts.setAvailability(availability);
			foodProducts.setPrice(price);
			foodProducts.setMenu(menu);

			list.add(foodProducts);
			menu.setFoodProducts(list);
			menu.setUser(user);
			user.setMenu(menu);

			menuDao.addMenu(menu);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddMenu.jsp");
			requestDispatcher.include(req, resp);

			
		}
		
	}

}
