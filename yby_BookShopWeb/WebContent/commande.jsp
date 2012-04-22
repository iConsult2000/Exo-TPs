<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commande panier </title>
</head>
<body> --%>
	<div>
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="com.sqli.bookShop.persistance.Commande" %>
		<%@ page import="com.sqli.bookShop.persistance.LigneDeCommande" %>
		<%@ page import="com.sqli.bookShop.persistance.Article" %>
		<p>Commande </p>
		<br><br>		
		<% if ( session.getAttribute("shoppingCart") != null) {
		Commande com = (Commande) session.getAttribute("shoppingCart");	%>
		<p>N Commande : <%=com.getNumeroCommande() %></p>
		<br>
		<% float somme = 0 ;
		 int qte = 0 ;%>
		<table cellpacing=0 cellpadding=0 border="0px" width="200px">
			<tr>
				<td>Article</td>
				<td>prix</td>
				<td>Qte</td>
			</tr>
			<% for (LigneDeCommande lign : (ArrayList<LigneDeCommande>) com.getLignesDeCommande() ){ %>
			<tr>
				<td><%=lign.getArticle().getNumeroArticle() %></td>
				<td><% somme = somme + lign.getArticle().getPrix() ;%>
				<%=lign.getArticle().getPrix()%></td>
				<td><% qte = qte + lign.getQuantite();%>
				<%= lign.getQuantite()%></td>
			</tr>
			 <% } %>
		</table>
		<% }else{ %>
			<p>Panier vide</p>
		<% } %>		
	</div>
<!-- </body>
</html> -->