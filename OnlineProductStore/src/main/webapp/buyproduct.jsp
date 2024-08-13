<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.onlinestore.AddProductBean"%>
<%@page import="com.onlinestore.UserBean"%>
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
	UserBean ub = (UserBean) session.getAttribute("ubean");
	ArrayList<AddProductBean> al = (ArrayList<AddProductBean>) session.getAttribute("alist");
	String pCode = request.getParameter("pcode");
	out.println("Page Belongs to User :" + ub.getfName());
	Iterator<AddProductBean> it = al.iterator();
	while (it.hasNext()) {
		AddProductBean apb = (AddProductBean) it.next();
		if (pCode.equals(apb.getpCode())) {
	%>
	<div align="center">
		<h1>Buy</h1>
		<form action="Buyy">
			PCode:<input type="text" value=<%=apb.getpCode()%>><br>
			PName:<input type="text" value=<%=apb.getpName()%>><br>
			PPrice:<input type="text" value=<%=apb.getpPrice()%>><br>
			PQty:<input type="text" value=<%=apb.getpQty()%>><br>
			Required:<input type="text" name='Req'><br> 
			<input type="submit" value='BUY'>
		</form>
	</div>
	<%
	}
	}
	%>
</body>
</html>