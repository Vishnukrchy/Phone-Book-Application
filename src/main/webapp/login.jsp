<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="components/allCSS.jsp"%>
</head>
<body style="background-color: #F5F5F5">
	<%@ include file="components/navBar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Login Here</h4>
						<!-- Code For Log in Massage  -->
						<%
						HttpSession httpSession1 = request.getSession();
						String loginMsg = (String) httpSession1.getAttribute("loginMsg");
						if (loginMsg != null) {
						%>
						<p style="text-align: center; color: red"><%=loginMsg%></p>
						<%
						httpSession1.removeAttribute("loginMsg");
						}
						%>
						      <!-- Code For Log Out  Massage  -->
						<%
						String loutMsg = (String) httpSession1.getAttribute("logoutMassage");
						if (loutMsg != null) {
						%>
						<p class="text-center text-success"><%=loutMsg%></p>
						<%
						httpSession1.removeAttribute("logoutMassage");
						}
						%>

						<form action="login" method="post">
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
								<button type="submit" class="btn btn-primary mt-10">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 140px">
		<%@ include file="components/footer.jsp"%>
	</div>
</body>
</html>
