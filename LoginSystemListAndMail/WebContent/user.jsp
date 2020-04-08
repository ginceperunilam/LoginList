<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="Login.Registration.Model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Users user = (Users) request.getAttribute("user");
if(user != null)
{
%>
		<table style="background-color: lightgreen; margin-left: 20px;">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value =<%= user.getName() %>></td>
			</tr>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="userName" value =<%= user.getUserName() %>></td>
			</tr>
		</table>
		<%} %>
</body>
</html>