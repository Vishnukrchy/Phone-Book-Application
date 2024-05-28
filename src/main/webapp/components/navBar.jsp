<%@page import="com.jspider.phone.dto.User"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="jakarta.servlet.http.HttpServlet"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary ">
	<a class="navbar-brand" href="#"><i class="fa-solid fa-phone"></i>
		Phone-Book</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link active"
				href="home.jsp"><i class="fa-solid fa-house"></i> Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link"
				href="addContact.jsp"><i class="fa-solid fa-plus"></i> Add Phone
					No</a></li>

			<li class="nav-item active"><a class="nav-link disabled"
				href="viewContact.jsp?id"> <i class="fa-solid fa-eye"></i>View
					Contact
			</a></li>
		</ul>
		<%
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("userDetails");
		if (user == null) {
		%>

		<form class="form-inline my-2 my-lg-0">

			<a href="login.jsp" class="btn btn-success"><i
				class="fa-solid fa-right-to-bracket"></i> Login</a> <a
				href="register.jsp" class="btn btn-danger ml-2"><i
				class="fa-solid fa-user"></i> Register</a>
		</form>
		<%
		} else {
		%>
		<form class="form-inline my-2 my-lg-0">

			<p class="btn btn-success m-2">
				<i class="fa-solid fa-circle-user"></i>
				<%=user.getName()%></p>
			<a data-toggle="modal" data-target="#exampleModal"
				class="btn btn-danger ml-2"><i class="fa-solid fa-user text-white"></i>
				Logout</a>
		</form>
		<%
		}
		%>

	</div>
	<!-- Code For The LogOut Modal Popup  -->
	<!-- Button trigger modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button> -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" >Warning</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<p class="text-center text-danger"> Do You Want LogOut</p>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="logout"><button type="button" class="btn btn-primary">Logout</button></a>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
</nav>