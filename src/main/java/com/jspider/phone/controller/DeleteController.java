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

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int contactId=Integer.parseInt(req.getParameter("cId"));
         ContactDao contactDao=new ContactDao();
       boolean result=  contactDao.deleteContactDetails(contactId);
   	
//		Code For The DELETE Session Object
		HttpSession httpSession=req.getSession();
		
		if (result) {
			httpSession.setAttribute("editSucMsg", " Details is DELETED");
			resp.sendRedirect("viewContact.jsp");
		} else {
			httpSession.setAttribute("editFaildMsg", " Details is Not DELETED");
			resp.sendRedirect("viewContact.jsp");

		}
	}
}
