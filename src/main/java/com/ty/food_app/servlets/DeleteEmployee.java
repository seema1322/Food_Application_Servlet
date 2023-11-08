package com.ty.food_app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.UserDao;

@WebServlet(value ="/deleteemployee")
public class DeleteEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter= resp.getWriter();
		long phone= Long.parseLong(req.getParameter("phone"));
		
		UserDao userDao= new UserDao();
		try {
			userDao.deleteUser(phone);
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("ViewEmployee.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (NoResultException e) {
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("ViewEmployee.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	

}
