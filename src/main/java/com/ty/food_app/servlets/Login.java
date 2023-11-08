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
import javax.servlet.http.HttpSession;

import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.User;
import com.ty.food_app.exceptions.UserNotFoundException;

@WebServlet(value="/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter= resp.getWriter();
		HttpSession session= req.getSession();
		
		long phone= Long.parseLong(req.getParameter("User_Phone"));
		String password= req.getParameter("User_Password");
		UserDao userDao= new UserDao();
		
		try {
			User user=userDao.findUserByPhonePassword(phone, password);
			
			if (user.getRole().equalsIgnoreCase("Manager")) {
				session.setAttribute("User", user);
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("ManagerHome.jsp");
				requestDispatcher.forward(req, resp);
			} else if(user.getRole().equalsIgnoreCase("Employee")) {
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("EmployeeHome.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("CustomerHome.jsp");
				requestDispatcher.forward(req, resp);
			}
			
		} catch (NoResultException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h2 style='text-align:center;'>Invalid Credentials</h2>");
			printWriter.print("</body></html>");
			
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		} catch (UserNotFoundException e) {
			printWriter.print("<html><body>");
			printWriter.print("<h2 style='text-align:center;'>Invalid Credentials</h2>");
			printWriter.print("</body></html>");
			
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	
}
