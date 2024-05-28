<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/allCSS.jsp"%>

</head>
<body>
	<%@include file="components/navBar.jsp"%>
	<!-- Code For Log in before Added contact -->
	<%
	if (user == null) {
		httpSession.setAttribute("loginMsg", "please login...");
		response.sendRedirect("login.jsp");
	%>

	<%
	}
	%>
	<!-- Code for the Add Contact Details -->
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Contact Details</h4>
						<!-- Code for Getting massage after user added contact form details  -->
						<%
						HttpSession httpSession2 = request.getSession();
						String contactAddMsg = (String) httpSession.getAttribute("conAddedMsg");
						if (contactAddMsg != null) {
						%>
						<p class="text-center text-success"><%=contactAddMsg%></p>
						<%
						httpSession.removeAttribute("conAddedMsg");
						}
						%>
						<%
						String contactFaildMsg = (String) httpSession.getAttribute("conFailedMsg");
						if ( contactFaildMsg!= null) {
						%>
						<p class="text-center text-danger"><%=contactFaildMsg%></p>
						<%
						httpSession.removeAttribute("conFailedMsg");
						}
						%>

						<form action="addContact" method="post">
							<!-- Code For check  user is log in then show/hide input User id on addcontact
						form and get the value of User id Which user is login and send into back-end 
						 AddContact Servlets and save it into database in Contact table-->

							<%
							if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
							}
							%>

							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name"
									name="name">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone No</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name"
									name="phoneNo">

							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">About</label>
								<textarea rows="" cols="" class="form-control"
									id="exampleInputPassword1" placeholder="Enter Details"
									name="about"></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary mt-10">Save Details</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>