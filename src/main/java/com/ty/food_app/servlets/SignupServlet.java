package com.ty.food_app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.UserDao;
import com.ty.food_app.entity.Branch;
import com.ty.food_app.entity.User;

@WebServlet(value = "/signup")
public class SignupServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao= new UserDao();
		PrintWriter printWriter= resp.getWriter();
		String name= req.getParameter("User_Name");
		long phone= Long.parseLong(req.getParameter("User_Phone"));
		String password= req.getParameter("Password");
		String role="Manager";
		
		String branchName= req.getParameter("Branch_name");
		String branchAddress= req.getParameter("Branch_Address");
		long branchPhone= Long.parseLong(req.getParameter("Branch_Phone"));
		String branchEmail= req.getParameter("Branch_Email");
		
		Branch branch = new Branch();
		branch.setName(branchName);
		branch.setAddress(branchAddress);
		branch.setPhoneNumber(branchPhone);
		branch.setEmail(branchEmail);
		
		
		User manager= new User();
		
		manager.setName(name);
		manager.setPhone(phone);
		manager.setPassword(password);
		manager.setRole(role);
		List<Branch> branches= new ArrayList<Branch>();
		branches.add(branch);
		branch.setUser(manager);
		manager.setBranch(branches);
		try {
			User user=userDao.findUserByPhone(phone);
			if (!(user.getRole().equalsIgnoreCase("manager"))) {
				userDao.addBranchManager(manager);
				printWriter.print("<html><body>");
				printWriter.print("<h2 style='text-align:center;'>Account Created</h2>");
				printWriter.print("</body></html>");
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(req, resp);
			
			} else {
				printWriter.print("<html><body>");
				printWriter.print("<h2 style='text-align:center;'>Manager Already Present</h2>");
				printWriter.print("</body></html>");
				RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
				requestDispatcher.include(req, resp);
			}
		} catch (NoResultException e) {
			userDao.addBranchManager(manager);
			printWriter.print("<html><body>");
			printWriter.print("<h2 style='text-align:center;'>Account Created</h2>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	

}
