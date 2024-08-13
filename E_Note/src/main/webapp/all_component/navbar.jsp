
<%@page import="com.ankit.user.UserBean"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i class="fa fa-book"
			aria-hidden="true"></i>E Notes</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link " href="home.jsp"><i
						class="fa fa-home" aria-hidden="true"></i>Home</a></li>
				<li class="nav-item"><a class="nav-link" href="addNotes.jsp"> <i
						class="fa fa-plus-circle" aria-hidden="true"></i>Add Note
				</a></li>

				<li class="nav-item"><a class="nav-link " href="ShowNotes.jsp"> <i
						class="fa fa-address-book" aria-hidden="true"></i> Show Notes
				</a></li>
			</ul>
			<%
			UserBean user = (UserBean) session.getAttribute("userD");
			if (user != null) {
			%><form class="form-inline my-2 my-lg-0">
				<a href="#" class="btn btn-light  my-2 my-sm-0 "
					type="submit"><i class="fa fa-user-circle-o" aria-hidden="true"></i><%= user.getFull_Name() %></a>
				<a href="LogoutServlet" class="btn btn-light my-2 my-sm-0 "
					type="submit"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
			</form>
		    <%
			} else {
			%>
			<form class="form-inline my-2 my-lg-0">
				<a href="login.jsp" class="btn btn-light  my-2 my-sm-0 "
					type="submit"><i class="fa fa-user-circle-o" aria-hidden="true"></i>Login</a>
				<a href="register.jsp" class="btn btn-light my-2 my-sm-0 "
					type="submit"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
			</form>
			<%
			}
			%>
		</div>
		
	</div>
	
	
</nav>