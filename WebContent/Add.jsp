<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert into Database</title>
</head>
<body>

<a href="http://localhost:8080/FaultReportSystem/faults">See all faults</a>
<a href="http://localhost:8080/FaultReportSystem/Logout.jsp">Log out</a>

<form  action="/FaultReportSystem/fault" method="post">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>Enter the error code: </td>
			<td><input type="text" name="txtEC" size="20"/></td>
		</tr>
		<tr>
			<td>Severity(Low/Medium/High): </td>
			<td>
					<select name="txtSev"/>
						<option value="Low">Low</option>
						<option value="Medium">Medium</option>
						<option value="High">High</option>
					</select>
			</td>
		</tr>
		<tr>
			<td>Enter a description: </td>
			<td><input type="text" name="txtDesc" size="80"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Submit" name="B1"/>
				<input type="reset" value="Clear" name="B2"/>
			</td>
		</tr>
	</table>
</form>


</body>
</html>