<%@page import="com.jspider.phone.dto.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.jspider.phone.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/allCSS.jsp"%>

<style type="text/css">
.card-ho:hover {
	background-color: gray;
	box-shadow: 2px 2px 5px gray;
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="components/navBar.jsp"%>
	<!-- Code For Log in before View contact
	Here user comes from navBar which contains all the user Details -->
	<%
	if (user == null) {
		httpSession.setAttribute("loginMsg", "please login...");
		response.sendRedirect("login.jsp");
	%>

	<%
	}
	%>
	<!-- Code for Display Update details massage -->
	<%
	String upSucessMsg = (String) httpSession.getAttribute("editSucMsg");
	if (upSucessMsg != null) {
	%>
	<div class="alert alert-primary" role="alert">
		<p class="text-center "><%=upSucessMsg%></p>
	</div>
	<%
	httpSession.removeAttribute("editSucMsg");
	}
	%>
	<%
	String upFailedMsg = (String) httpSession.getAttribute("editFaildMsg");
	if (upFailedMsg != null) {
	%>
<div class="alert alert-danger" role="alert">
	<p class="text-center "><%=upFailedMsg%></p>
</div>
	<%
	httpSession.removeAttribute("editFaildMsg");
	}
	%>
	<!--  Code For Display Records -->
	<div class="container">
		<div class="row p-4">

			<!--  card hover card-ho -->
			<%
			/* Here if(user!=null) is uses to show the detais below after user log in if not using 
			this is given null pointer expcetion and then value is null */
			if (user != null) {
				ContactDao contactDao = new ContactDao();
				/* List can strore contcat details for dispaly details */
				List<Contact> contatList = contactDao.getAllContactDetails(user.getId());
              //out.print(contatList);
				for (Contact c : contatList) {
			%>
			<div class="col-md-3">
				<div class="card card-ho">
					<div class="card-body bg-light">
						<h5>
							Name :
							<%=c.getName()%></h5>
						<p>
							Ph.No :<%=c.getPhone_no()%></p>
						<p>
							Email :
							<%=c.getEmail()%></p>
						<p>
							About :<%=c.getAbout()%></p>
						<div class="text-center">
							<!-- the id attributes set here same parameter should be get in edit edit.jsp  -->
							<a href="editContact.jsp?cId=<%=c.getId()%>"
								class="btn btn-success btn-sm text-white">Edit</a> <a href="delete?cId=<%=c.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>

					</div>
				</div>
			</div>
			<%
			}
			}
			%>

		</div>
	</div>
</body>
</html>