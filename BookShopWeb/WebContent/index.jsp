<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ingesup.bookshop.persistance.Article" %>

<br/>
<p>Liste des articles :</p>
<table>
	<th>Numéro</th>
	<th>Libèlle</th>
	<th>Prix</th>
		<% 
		if(session.getAttribute("Articles") != null){
		ArrayList<Article> Articles = (ArrayList<Article>) session.getAttribute("Articles");
		for(Article a : Articles) { %>
		<tr>
			<td><%=a.getNumeroArticle()%></td><td><%=a.getLibelle()%></td><td><%=a.getPrix()%></td><td><a href="#">Add to cart</a></td>
		</tr>
		<% }} %>
</table>


<!-- <form action="./ajouter" method="post">
	<table>
		<th>Libelle</th>
		<th>Prix</th>
		<tr>
			<td><input type="text" name="libelle"/></td>
			<td><input type="text" name="prix"/></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="valider"/></td></tr>
	</table>
</form> -->
</body>
</html>