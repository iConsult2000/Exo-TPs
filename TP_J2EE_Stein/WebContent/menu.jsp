<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
			<a href="accueil.jsp">Accueil </a>	  -		  
			<% if (session.getAttribute("nom") != null) { %> 
			<a href="Logout"> Déconnexion</a>
			<a href="information.jsp">Informations Membre </a>
			| Connecté sous <%= session.getAttribute("nom").toString()%>
			<% }else{ %>
			<a href="connexion.jsp">Connexion</a>
			<%} %>
</body>
</html>