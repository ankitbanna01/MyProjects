<%@page import="java.util.Iterator"%>
<%@page import="com.onlinestore.AddProductBean"%>
<%@page import="com.onlinestore.UserBean"%>
<%@page import="com.onlinestore.AdminBean"%>
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
UserBean ub=(UserBean)session.getAttribute("ubean");
ArrayList<AddProductBean> al=(ArrayList<AddProductBean>)session.getAttribute("alist");
out.println("Page Blongs to User :"+ub.getfName()+"<br>");
if (al.size() == 0) {
	out.println("No product is Available...<br>");
} else {
	Iterator<AddProductBean> it = al.iterator();
	while (it.hasNext()) {
		AddProductBean apb = (AddProductBean) it.next();
		out.println(apb.getpCode() + "&nbsp&nbsp" + apb.getpName() + "&nbsp&nbsp" + apb.getpPrice() + "&nbsp&nbsp"
		+ apb.getpQty() + "&nbsp&nbsp "+
		"<a href='buy?pcode="+apb.getpCode()+"'>Buy</a>"+"&nbsp&nbsp"+"<br>");
	}
}

%>
<a href='logout1'>LogOut</a>

</body>
</html>