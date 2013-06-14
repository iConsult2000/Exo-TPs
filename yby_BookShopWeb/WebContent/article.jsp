<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un article</title>
</head>
<body>
	<div  align="center" id="center">
		<div><h3>Ajout d'article</h3></div>
		<% if ( session.getAttribute("art") != null ){ %>
			<div style="color:green;">Votre article '<%=session.getAttribute("art").toString() %>' a bien été ajouté </div>
		<% } %>
		<br>
		<form method="post" action="AddArticleBdd" >
			<label style="width:100px;">Libelle: </label><input type="text" name="libelle" /><br>
			<label style="width:100px;"> Filière:</label> <input type="text" name="filiere" /><br>
			<label style="width:100px;"> Prix:</label> <input type="text" name="prix" /><br>
			<label style="width:100px;"> Quantité:</label> <input type="text" name="quantite" /><br><br>				
			<label style="width:100px;">&nbsp;</label><input type="submit" name="submit" value="Valider" />
		</form> 
		<br>
		<p><a href="ListeArticles"> <<</a> Liste d'articles</p>
	</div>
</body>
</html>