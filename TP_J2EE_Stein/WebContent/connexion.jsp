<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
		<%@ include file="menu.jsp"%>
		<br>
			<h3>Connexion</h3>
		<% if (session.getAttribute("nom") == null){%>
			<form method="post" action="Login" >
				<label style="width:100px; float:left;">Login </label><input type="text" name="login" /><br>
				<label style="width:100px; float:left;">Password </label> <input type="password" name="pass" /><br>
				<input type="submit" name="Connexion" value="Connexion" />
			</form> 
			<% }else{ %> <p>Bonjour <%=session.getAttribute("nom").toString() %></p> 
			<p>Bienvenue sur votre espace confidentielle<p>
			<% } %>
</body>
</html>