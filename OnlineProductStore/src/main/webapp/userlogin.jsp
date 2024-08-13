<%@page import="com.onlinestore.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("Page Blongs to USer :"+ub.getfName());
%>
<div align="center">
<a href='view1'>ViewProduct</a><br>
<a href='logout'>LogOut</a>
</div>
</body>
</html>