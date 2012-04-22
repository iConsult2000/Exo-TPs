<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP BookShop | EJB Application Web </title>
</head>
<body>
	<div align="center">Bienvenue sur mon application EJB
	

	<%@ page import="java.util.ArrayList" %>
	<%@ page import="com.sqli.bookShop.persistance.Article" %>
		<jsp:useBean id="appContent" class="com.sqli.bookShop.persistance.Article"/>
		<br><br>
		<div id="centre">
		<h3>Liste des articles</h3>
		<br>
		<table cellspcing="0" cellpadding="0" border="0px" width="700px">
			<tr>
				<td>Numéro </td><td>Libelle<td>Filière </td><td>Prix €</td><td></td>
			<tr>
				<% ArrayList<Article> list = (ArrayList<Article>) session.getAttribute("lesArticles");
				for(Article art : list) { %>
				<tr>
					<td><a href="DetailArticle?num=<%=art.getNumeroArticle() %>"><%=art.getNumeroArticle()%></a></td><td><%=art.getLibelle()%></td><td><%=art.getFiliere()%></td><td><%=art.getPrix()%></td><td><a href="AddArticleToShoppingCart?num=<%=art.getNumeroArticle() %>">Add to cart</a></td>
				</tr>
				<% } %>
		</table>
		</div>
	</div>
</body>
</html>