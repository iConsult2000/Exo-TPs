<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.bookshop.persistance.Produit"%>
	<jsp:useBean id="sessionbondecommande" class="com.bookshop.models.PurchaseOrder"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/style.css" />
<title>TP EJB 3.0 + Servlet</title>
</head>
<body>
	<div class="menu">
		
		<a href="logout">Fermer la session</a>


	</div>

	<div class="container">
		<table border=1px color=red cellpadding=0 cellspacing=0>
		<tr>Commande n° <%=sessionbondecommande.getNo_commande() %>
		<tr>
			<td>Reference_Produit</td>
			<td>Designation</td>
			<td>Quantité</td>
			<td>Prix</td>	

		</tr>
		<%
			for (Produit myprod : sessionbondecommande.getListProduits()){
		%>
		<tr>
			<td><%=myprod.getRef_produit()%></td>
			<td><%=myprod.getNom_produit()%></td>
			<td>non implementée</td>
			<td><%=myprod.getPrix_unitaire()%></td>
		</tr>


		<%
			}
		%>
		<tr> <td>Montant total</td>
		<td> <%=sessionbondecommande.getMontant() %>
	</table>
		
	</div>
	
	<div class="footer">
		<br>
		<hr>
		<p>&copy; Travaux Pratiques Ingesup 2011</p>

	</div>
</body>
</html>