<%@page import="java.util.*"%>
<%@page import="com.onlinestore.AdminBean"%>
<%@page import="com.onlinestore.AddProductBean"%>
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
ArrayList<AddProductBean> al=(ArrayList<AddProductBean>)session.getAttribute("alist");
String pCode=request.getParameter("pcode");
out.println("Page Blong to admin"+ab.getfName()+"<br>");
Iterator<AddProductBean> it=al.iterator();
while(it.hasNext())
{
	AddProductBean apb=(AddProductBean)it.next();
	if(pCode.equals(apb.getpCode()))
	{
		%>
		<div align="center">
		<h1><u>Edit Product</u> </h1>
		<form action="update" method="post">
		<input type="hidden" name="pcode" value=<%=apb.getpCode()%>>
		 Price:<input type="text" placeholder="ProductPrice"  name="pprice"  value=<%=apb.getpPrice() %>><br>
		 QTY:<input type="text" placeholder="ProductQTY"  name="pqty"  value=<%=apb.getpQty() %>> <br>
		  <input type="submit" value="EditProduct" >
		</form>
		</div>
		<% 
		break;
	}	
}

%>

</body>
</html>