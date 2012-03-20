<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informations Membre</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
		<br>
		<p> L'identifiant de votre sessions : <%= session.getId().toString() %><br></p>
		<p> Le moment de création de la session : <%= session.getCreationTime() %> </p>
</body>
</html>