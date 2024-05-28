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

@WebServlet(value = "/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email);
		UserDao userDao = new UserDao();
		User user = userDao.loginUser(email);
		System.out.println(user);

		HttpSession httpSession = req.getSession();
		if (user != null) {
			if (email.equals(user.getEmail())) {
				if (password.equals(user.getPassword())) {
					httpSession.setAttribute("userDetails", user);
					resp.sendRedirect("home.jsp");
					System.out.println("User Log in Succesfully");
				} else {
					httpSession.setAttribute("loginMsg", "Invaild Password");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					;

				}
			}
		} else {
			httpSession.setAttribute("loginMsg", "Invaild Email");
			resp.sendRedirect("login.jsp");
			System.out.println(" Not Log in");
		}
	}
}
