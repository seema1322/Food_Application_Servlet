package com.ty.food_app.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.User;

@WebServlet(value = "/addcustomer")
public class AddCustomer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("Password");
		String role = "Customer";

		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setPassword(password);
		user.setRole(role);

		UserDao userDao = new UserDao();
		userDao.addEmployee(user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewCustomer.jsp");
		requestDispatcher.forward(req, resp);
	}

}
