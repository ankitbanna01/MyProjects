<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
out.println(msg+"<br>");
%>
<a href="addproduct.html">AddProduct</a><br>
<a href="view">ViewProduct</a><br>
<a href="logout">LogOut</a>

</body>
</html>