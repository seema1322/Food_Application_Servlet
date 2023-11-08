package com.ty.food_app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.User;

@WebServlet(value = "/addemployee")
public class AddEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		PrintWriter printWriter= resp.getWriter();
		
		String empName= req.getParameter("Emp_Name");
		long empPhone= Long.parseLong(req.getParameter("Emp_Phone"));
		String pass= req.getParameter("Password");
		String role="Employee";
		User employee= new User();
		employee.setName(empName);
		employee.setPhone(empPhone);
		employee.setPassword(pass);
		employee.setRole(role);
		
		userDao.addEmployee(employee);
		printWriter.print("<html><body>");
		printWriter.print("<h2 style='text-align:center; color:White;'>Employee On-Boarded</h2>");
		printWriter.print("</body></html>");
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("RegisterEmployee.jsp");
		requestDispatcher.include(req, resp);
		
		
	}
	

}
