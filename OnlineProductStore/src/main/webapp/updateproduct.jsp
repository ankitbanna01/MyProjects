<%@page import="com.onlinestore.AdminBean"%>
<%@page import="com.onlinestore.AddProductBean"%>
<%@page import="java.util.ArrayList"%>
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
AdminBean ab=(AdminBean)session.getAttribute("adbean");
String msg=(String)request.getAttribute("msg");
out.println(msg+"  <br>");
out.println("Page Blongs to Addmin  :"+ab.getfName()+" <br>");

%>
<a href="addproduct.html">AddProduct</a><br>
<a href="view">ViewProduct</a><br>
<a href="logout">LogOut</a>

</body>
</html>