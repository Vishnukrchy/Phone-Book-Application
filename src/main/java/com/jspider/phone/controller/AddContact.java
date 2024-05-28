package com.jspider.phone.controller;

import java.io.IOException;

import com.jspider.phone.dao.ContactDao;
import com.jspider.phone.dto.Contact;
import com.jspider.phone.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNo = req.getParameter("phoneNo");
		String about = req.getParameter("about");
		
		Contact contact=new Contact(name, email, phoneNo, about, userId);
		ContactDao contactDao=new ContactDao();
		
		boolean result=contactDao.saveContact(contact);
		HttpSession httpSession=req.getSession();
		if (result) {
			httpSession.setAttribute("conAddedMsg", "Your contact Save Successfully");
			resp.sendRedirect("addContact.jsp");
			
		} else {

			httpSession.setAttribute("conFailedMsg", "Oops Something goes wrong");
			resp.sendRedirect("addContact.jsp");
		}
	}
}
