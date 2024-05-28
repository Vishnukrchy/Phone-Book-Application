<%@page import="com.jspider.phone.connection.PhoneConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/allCSS.jsp"%>
<style type="text/css">
body, html {
	height: 100%;
	margin: 0;
	display: flex;
	flex-direction: column;
}

.background-img {
	background: url("components/assets/homepage.png") no-repeat center
		center;
	background-size: cover;
	flex: 1;
}

.footer {
	background-color: #007bff;
	color: white;
	text-align: center;
	padding: 10px 0;
}
</style>
</head>
<body>
	<%@include file="components/navBar.jsp"%>
	<div class="conatiner background-img">
<%-- 	<%PhoneConnection con =new PhoneConnection(); 
	out.print(con);%> --%>
		<!-- 		<h1>Welcome To Phone Book App</h1> -->
	</div>
	<%@include file="components/footer.jsp"%>
</body>
</html>