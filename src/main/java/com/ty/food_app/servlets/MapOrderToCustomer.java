package com.ty.food_app.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.FoodOrderDao;
import com.ty.food_app.dao.FoodProductDao;
import com.ty.food_app.dao.ItemDao;
import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.FoodOrder;
import com.ty.food_app.entity.FoodProducts;
import com.ty.food_app.entity.Item;
import com.ty.food_app.entity.User;
@WebServlet(value = "/mapcustomerorder")
public class MapOrderToCustomer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		ItemDao itemDao= new ItemDao();
		FoodOrderDao foodOrderDao= new FoodOrderDao();
		
		long phone = Long.parseLong(req.getParameter("Phone"));
		
		User user= userDao.findUserByPhone(phone);
		
		String[] itemId= req.getParameter("Products").split(",");
		
		List<Item> itemList= new ArrayList<>();
		
		double totalPrice= 0;
		
		for (String string : itemId) {
			
			int id= Integer.parseInt(string);
			Item item=itemDao.findItemById(id);
			totalPrice+=item.getPrice();
			itemList.add(item);
		}
		
		FoodOrder foodOrder = new FoodOrder();
		String status = "Received";
		String customerName = user.getName();
		long customerPhone = user.getPhone();
		
		foodOrder.setTotalPrice(totalPrice);
		foodOrder.setStatus(status);
		foodOrder.setCustomerName(customerName);
		foodOrder.setContactNumber(customerPhone);
		foodOrder.setItems(itemList);
		foodOrder.setUser(user);
		
//		if (user.getFoodOrders()!=null) {
//			user.getFoodOrders().add(foodOrder);
//		} else {
//			List<FoodOrder> orderList= new ArrayList<>();
//			orderList.add(foodOrder);
//			user.setFoodOrders(orderList);
//		}
		foodOrderDao.saveFoodOrder(foodOrder);
		//userDao.updateUser(user);
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("EmployeeHome.jsp");
		requestDispatcher.forward(req, resp);
	}

}
