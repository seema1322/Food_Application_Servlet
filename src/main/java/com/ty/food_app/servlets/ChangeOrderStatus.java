package com.ty.food_app.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.FoodOrderDao;
import com.ty.food_app.entity.FoodOrder;

@WebServlet(value = "/changestatus")
public class ChangeOrderStatus extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		FoodOrderDao foodOrderDao= new FoodOrderDao();
		
		foodOrderDao.updateFoodOrder(id,"Order Delivered");
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("ViewCustomer.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	

}
