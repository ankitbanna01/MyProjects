<%@page import="java.io.PrintWriter"%>
<%@page import="com.ankit.user.UserData"%>
<%@page import="java.util.List"%>
<%@page import="com.ankit.dao.addnoteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserBean user3 = (UserBean) session.getAttribute("userD");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please Login....");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Note</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%><br>
	<%
	  String updateMsg=(String) session.getAttribute("updateMsg");
	  if(updateMsg!=null)
	  {%>
		  <div class="alert alert-success" role="alert"><%=updateMsg%>
					</div>
	 <%
	   session.removeAttribute("updateMsg");
	 }
	
	%>
	
	<%
	  String wrongmsg=(String) session.getAttribute("WrongMsg");
	  if(wrongmsg!=null)
	  {%>
		  <div class="alert alert-danger" role="alert"><%=wrongmsg%>
					</div>
	 <%
	   session.removeAttribute("WrongMsg");
	 }
	
	%>
	
	<div class="container">
		<h2 class="text-center">All Notes</h2>
		<div class="row">
			<div class="col-md-12">
				<%
				if (user3 != null) {
					addnoteDAO ad = new addnoteDAO();
					List<UserData> ld = ad.getData(user3.getId());
					for (UserData us : ld) {
				%>
				<div class="card mt-3">
					<img alt="" src="Image/start.jpg" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">

					<div class="card-body p-4">

						<h5 class="card-title"><%=us.getTitle()%></h5>
						<p><%=us.getContent()%></p>

						<p>
							<b class="text-success">Published By :<%=user3.getFull_Name()%>
							</b> <b class="text-primary"></b>
						</p>

						<div  class="container text-center mt-2">
							<a href="deleteNotes?note_id=<%=us.getId() %>" class="btn btn-danger">Delete</a> 
							<a href="edit.jsp?note_id=<%=us.getId() %>"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>