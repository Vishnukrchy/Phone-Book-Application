package com.jspider.phone.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession httpSession=req.getSession();
	   httpSession.removeAttribute("userDetails");
	   /*
	    * new http session old get destroyed
	    */
	   HttpSession httpSession2=req.getSession();
	   httpSession2.setAttribute("logoutMassage", "Logout Sucessfully");
	   
	   resp.sendRedirect("login.jsp");
	   
	   
	   
			   
	}

}
