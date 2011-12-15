<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification User </title>
<style type="text/css">
  #menu li {
  float: left;
  list-style-type:none;
  margin-left:10px;
 
 }
 </style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<div>
		<h3>Connexion</h3>
	</div>
	<% if (session.getAttribute("nom") == null){%>
	<div>
		<form method="post" action="connexion" >
			<label style="width:100px; float:left;">Login: </label><input type="text" name="login" /><br>
			<label style="width:100px; float:left;"> mot de passe:</label> <input type="password" name="pass" /><br>
			<label style="width:100px; float:left;">&nbsp;</label><input type="submit" name="connexion" value="Valider" />
		</form> 
	</div>
	<% }%>
	<div>
		<% if (session.getAttribute("nom") != null) { %> <p>Bonjour <%=session.getAttribute("nom").toString() %></p> 
		<p>Bienvenue sur votre espace confidentielle<p>
		<% } %>
		
	</div>
</body>
</html>