<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="continer-fluid div-color">
		<div Class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>

					<%
					String regmsg = (String) session.getAttribute("reg-sucess");
					if (regmsg != null) {
					%>
					<div class="alert alert-success" role="alert">
						<%=regmsg%>Login<a href="login.jsp">click Here</a> >
					</div>
					<%
					session.removeAttribute("reg-sucess");
					}
					%>

					<%
					String failmsg = (String) session.getAttribute("failed-msg");
					if (failmsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=failmsg%></div>
					<%
					session.removeAttribute("failed-msg");
					}
					%>
					<div class="card-body">
						<form action="register" method="post">
							<div class="mb-3">
								Full Name <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="uname">
							</div>
							<div class="mb-3">
								Email address <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email">
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="pword">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>

</body>
</html>