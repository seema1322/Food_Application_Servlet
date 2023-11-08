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
import com.ty.food_app.dao.FoodProductDao;
import com.ty.food_app.dao.ItemDao;
import com.ty.food_app.entity.FoodProducts;
import com.ty.food_app.entity.Item;

@WebServlet(value = "/placeorder")
public class PlaceOrder extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productId= Integer.parseInt(req.getParameter("productid"));
		int quantity= Integer.parseInt(req.getParameter("quantity"));
		
		ItemDao itemDao= new ItemDao();
		FoodProductDao foodProductDao= new FoodProductDao();
		FoodProducts foodProducts= foodProductDao.findFoodProductById(productId);
		
		String name= foodProducts.getName();
		String type = foodProducts.getType();
		double Price = foodProducts.getPrice()*quantity;
		
		Item item= new Item();
		item.setName(name);
		item.setType(type);
		item.setType(type);
		item.setQuantity(quantity);
		item.setPrice(Price);
		item.setProductId(productId);
		
		itemDao.saveItem(item);
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("AddItem.jsp");
		requestDispatcher.forward(req, resp);
	}

}
