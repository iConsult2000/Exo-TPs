<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./lister">liste</a>
<br/>
<% if(session.getAttribute("listeLibelles") != null || session.getAttribute("listePrix") != null){ %>
<p>Liste des articles :</p>
<table>
	<th>Libelle</th>
	<th>Prix</th>
	<% //for (int i=0;i<session.getAttribute("nbArticle");i++){ %>
	<tr>
		<td><%= session.getAttribute("nbArticles").toString()%></td>
		<td><%= session.getAttribute("listePrix").toString()%></td>
	</tr>
	<% //} %>
</table>
 
<% } %>

<form action="./ajouter" method="post">
	<table>
		<th>Libelle</th>
		<th>Prix</th>
		<tr>
			<td><input type="text" name="libelle"/></td>
			<td><input type="text" name="prix"/></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="valider"/></td></tr>
	</table>
</form>
</body>
</html>