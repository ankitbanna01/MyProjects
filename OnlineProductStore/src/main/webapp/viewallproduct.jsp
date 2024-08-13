<%@page%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.onlinestore.AdminBean"
	import="java.util.*" import="com.onlinestore.AddProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("adbean");
	ArrayList<AddProductBean> al = (ArrayList<AddProductBean>) session.getAttribute("alist");
	out.println("Page is Belong :" + ab.getfName()+"<br>");
	if (al.size() == 0) {
		out.println("No product is Available...<br>");
	} else {
		Iterator<AddProductBean> it = al.iterator();
		while (it.hasNext()) {
			AddProductBean apb = (AddProductBean) it.next();
			out.println(apb.getpCode() + "&nbsp&nbsp" + apb.getpName() + "&nbsp&nbsp" + apb.getpPrice() + "&nbsp&nbsp"
			+ apb.getpQty() + "&nbsp&nbsp "+
			"<a href='edit?pcode="+apb.getpCode()+"'>Edit</a>"+"&nbsp&nbsp"+
			
			"<a href='delet?delet="+apb.getpCode()+"'>Delet</a>"+"&nbsp&nbsp <br>");
		}
	}
	%>
	<a href='addproduct.html'>AddProduct</a>

</body>
</html>