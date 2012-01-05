<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<form method="post" action="./connexion">
<table>
	<tr>
		<td>
			<a>Login</a>
		</td>
		<td>
			<input type="text" name="login"/>
		</td>
	</tr>
	<tr>
		<td>
			<a>Password</a>
		</td>
		<td>
			<input type="password" name="pwd"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="OK">
		</td>
		
</table>

</form>
</body>
</html>