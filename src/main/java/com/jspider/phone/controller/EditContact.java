package com.jspider.phone.controller;

import java.io.IOException;

import com.jspider.phone.dao.ContactDao;
import com.jspider.phone.dto.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editContact")
public class EditContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		//System.out.println(userId);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNo = req.getParameter("phoneNo");
		String about = req.getParameter("about");

		Contact contact = new Contact(userId, name, email, phoneNo, about, userId);
		ContactDao contactDao = new ContactDao();
		//System.out.println("=>"+contact);
		boolean result=contactDao.updateContactDetails(contact);
		//System.out.println(result);
//		Code for the UPDATES session object
		HttpSession httpSession=req.getSession();
		
		if (result) {
			httpSession.setAttribute("editSucMsg", " Details is updated");
			resp.sendRedirect("viewContact.jsp");
		} else {
			httpSession.setAttribute("editFaildMsg", " Details is Not updated");
			resp.sendRedirect("viewContact.jsp");

		}
	}
}
