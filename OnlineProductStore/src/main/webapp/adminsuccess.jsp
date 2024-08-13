<%@page import="com.onlinestore.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("adbean");
		out.println("Wlcome Admin :" + ab.getfName() + ".......<br>");
		%>
		<a href="addproduct.html">AddProduct</a><br> <a href="view">ViewProduct</a><br>
		<a href="logout">LogOut</a>
	</div>
</body>
</html>