<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP BookShop | EJB Application Web </title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<div id="center">Bienvenue sur mon application EJB
			<%@ page import="java.util.ArrayList" %>
			<%@ page import="com.sqli.bookShop.persistance.Article" %>
				<br><br>
				<div id="left">
				<h3>Liste des articles &nbsp;<a href="article.jsp">Ajout un article</a></h3>
				<br>
				<table cellspcing="0" cellpadding="0" width="500px">
					<tr>
						<td>Ref </td><td>Libelle<td>Filière </td><td>Prix €</td><td></td>
					<tr>
						<% ArrayList<Article> list = (ArrayList<Article>) session.getAttribute("lesArticles");
						for(Article art : list) { %>
						<tr>
							<td><%=art.getNumeroArticle()%></td>
							<td><%=art.getLibelle()%></td>
							<td><%=art.getFiliere()%></td>
							<td><%=art.getPrix()%></td>
							<td><a href="AddArticle?action=add&num=<%=art.getNumeroArticle() %>">Add to cart</a></td>
						</tr>
						<% } %>
				</table>
				</div>
				<div id="right">
					<%@ include file="commande.jsp"%>
				</div>
	</div>
</body>
</html>