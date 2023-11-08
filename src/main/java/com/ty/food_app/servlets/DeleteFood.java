package com.ty.food_app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_app.dao.FoodProductDao;

@WebServlet(value = "/deletefood")
public class DeleteFood extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));

		FoodProductDao foodDao = new FoodProductDao();

		foodDao.deleteFoodProduct(id);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewMenu.jsp");
		requestDispatcher.include(req, resp);

	}

}
