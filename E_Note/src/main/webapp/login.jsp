<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="continer-fluid div-color">
		<div Class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i>
						<h4>Login</h4>
					</div>
					<%
					String failmsg = (String) session.getAttribute("login-failed");
					if (failmsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=failmsg%>
					</div>
					<%
					 session.removeAttribute("login-failed");
					 session.removeAttribute("userD");
					}
					%>
					<%
					   String  withoudLogin=(String)session.getAttribute("login-error");
					    if(withoudLogin!=null)
					    {%>
					    	<div class="alert alert-danger" role="alert"><%=withoudLogin%>
					</div>
					    <%
					    session.removeAttribute("login-error");
					    }
					%>
					
					<%
					   String lgmsg=(String) session.getAttribute("logoutMsg");
					    if(lgmsg != null)
					    {%>
					    	<div class="alert alert-success" role="alert"><%=lgmsg%>
					</div>
					   <%
					       session.removeAttribute("logoutMsg");
					       session.removeAttribute("userD");
					    }
					%>
					
					<div class="card-body">
						<form action="login" method="post">
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
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>

</body>
</html>