<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/style.css" />
<title>TP EJB 3.0 + Servlet</title>
</head>
<body>
	<div class="menu">
		<h1>Liste des articles du magasin</h1>
		<ul>
			<li>Liste des catégories</li>
			<li>champ de saisie</li>
			<li>bouton rechercher</li>
			
		</ul>
		<a href="logout">Fermer la session</a>


	</div>

	<div class="container">
		<jsp:include page="/WEB-INF/listeArticles.jsp" />
	
		<jsp:include page="/WEB-INF/monPanier.jsp" />
	</div>
	
	<div class="footer">
		<br>
		<hr>
		<p>&copy; Travaux Pratiques Ingesup 2011</p>

	</div>
</body>
</html>