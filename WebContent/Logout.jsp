<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="uk.ac.dundee.computing.joel.storage.userBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>You are now logged out</title>
</head>
<body>

<%
userBean nameT = (userBean) session.getAttribute("UserData");

nameT.setAuth(false);
%>

<form  action="/FaultReportSystem/login" method="get">

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>You are logged out. </td>   
		</tr>
		<tr>
			<td><input value="Continue" type="submit" name="B1"/></td>
		</tr>
	</table>
</form>


</body>
</html>