package com.jspider.phone.controller;

import java.io.IOException;

import com.jspider.phone.dao.UserDao;
import com.jspider.phone.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet( value = "/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao userDao = new UserDao();
		User user = new User(name, email, password);

		// Session Concepts
		HttpSession httpSession = req.getSession();
		boolean result = userDao.userRegister(user);
		System.out.println(result);
		if (result) {
			httpSession.setAttribute("registerMsg", "User Register Sucessfully");
			resp.sendRedirect("register.jsp");
			// System.out.println(" data is inserted in user table");

		} else {
			// System.out.println(" data is Not inserted in user table");
			httpSession.setAttribute("registerMsg", "User Not  Register ");
			resp.sendRedirect("register.jsp");

		}

	}
}
