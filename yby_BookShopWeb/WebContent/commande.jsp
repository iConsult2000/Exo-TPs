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
				<td>Qte</td>
				<td width="20px">prix</td>
				<!-- <td width="2px"></td> -->
				<td width="2px"></td>
			</tr>
			<% for (LigneDeCommande lign : (ArrayList<LigneDeCommande>) com.getLignesDeCommande() ){ 
				ArrayList<Article> lista = (ArrayList<Article>) session.getAttribute("lesArticles");
				for(Article art : lista) { 
					if (art.getNumeroArticle()== lign.getArticle().getNumeroArticle()){ Article a = art;%>
			<tr>
				<td><%=a.getLibelle() %></td>
				<td><% qte = qte + lign.getQuantite();%>
				<%= lign.getQuantite()%></td>
				<td width="20px"><% somme = somme + a.getPrix() ;%>
				<%=a.getPrix()%></td>
				<!-- <td width="2px"><a href="#">+</td> -->
				<td width="2px"><a href="AddArticle?action=del&num=<%=lign.getIdLigneDeCommande()%>">del</a></td>
			</tr>
				<% }//fin si 
				} //fin bouble liste article%>
			 <% } %>
			 <tr>
			 	<td>TOTAL</td><td><%=qte %></td><td><%=somme %> &euro;</td><td></td><td></td>
			 <tr>
		</table>
		<p><a href="#">Valider Achat</a></p>
		<% } else { %>
			<p>Panier vide</p>
		<% } %>		
	</div>
<!-- </body>
</html> -->