<%@page import="com.ankit.user.UserData"%>
<%@page import="com.ankit.dao.addnoteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
UserBean user1 = (UserBean) session.getAttribute("userD");
if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","Please Login....");	
}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
<%
 Integer noteid=Integer.parseInt(request.getParameter("note_id"));
 addnoteDAO ad=new addnoteDAO();
 UserData ud=  ad.getDataById(noteid);

%>

<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%><br>
		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="EditNotes" method="post">
					 <input type="hidden" value="<%=noteid%>" name="noteid">
					
					
					
						<div class="form-group">
							
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required" value="<%=ud.getTitle()%>">
						</div>
						<div class="form-group">
							<br>
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="15" cols="" class="form-control" name="content"
								required="required">  <%=ud.getContent() %> </textarea>
						</div>
						<br>
						<div class="container text-center">
							<button   type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br><%@include file="all_component/footer.jsp"%>

</body>
</html>