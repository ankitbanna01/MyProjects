<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserBean user2 = (UserBean) session.getAttribute("userD");
if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","Please Login....");	
}
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	
	<div class="container-fluid" >
	<%@include file="all_component/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center py-5">
				<img alt="" src="Image/start.jpg" class="img-fluid mx-auto" style="width: 520px">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>