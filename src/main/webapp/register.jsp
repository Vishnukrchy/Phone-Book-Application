<%@page import="java.util.concurrent.LinkedTransferQueue"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/allCSS.jsp"%>
</head>
<body style="background-color: #F5F5F5">
	<%@include file="components/navBar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Register Your Self</h4>
						<!--  Code For user register Session  -->
						<%
						HttpSession httpSession1 = request.getSession();
						String resisterMassage = (String) httpSession1.getAttribute("registerMsg");
						if (resisterMassage != null) {
						%>
						<p class="text-center text-success"><%=resisterMassage%></p>

						<%
						httpSession1.removeAttribute("registerMsg");
						}
						%>


						<form action="register" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name"
									name="userName">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email">

							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary mt-10">Register</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 55px">
		<%@include file="components/footer.jsp"%>
	</div>

</body>
</html>