<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>
	<!-- 	<form name="loginForm" action="j_security_check" method="post"> -->
	<!-- 		Login: <input type="text" name="j_username"/><br/> -->
	<!-- 		Password: <input type="password" name="j_password"/> -->
	<!-- 		<input type="submit" value="login"> -->

	<!-- 	</form> -->

	<form method="post"
		action="<%=response.encodeURL("j_security_check")%>">
		<table border="0">
			<tr>
				<td>Login</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>