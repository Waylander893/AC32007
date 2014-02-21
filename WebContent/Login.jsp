<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log into system</title>
</head>
<body>

<form  action="/FaultReportSystem/login" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>Username: </td>
			<td><input type="text" name="userName" size="20"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="userPass" size="20"/></td>     
		</tr>
		<tr>
			<td><input value="Login" type="submit" name="B1"/></td>
		</tr>

	</table>
</form>

</body>
</html>