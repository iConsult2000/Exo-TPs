<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/index.css" />
<title>Liste de Produits</title>
</head>
<body>
	<div id="content">
		<%@ include file="menu.jsp"%>
		<%@ page import="com.insia.org.models.Article" %>
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="com.insia.org.models.cart" %>
		<jsp:useBean id="appContent" class="com.insia.org.beans.articleContent"/>
		<br><br>
		<div id="centre">
		<h3>Liste de produits</h3>
			<% int i=0;
			for(Article app : appContent.getArticles()) { %>
			
				<span class="col<%=i%2%>">
					<a href="app?action=details&name=<%=app.getRef() %>"><%=app.getRef() %></a>
					<br>
					Prix : <strong><%=app.getPrice() > 0 ? app.getPrice() : "Gratuit" %>&euro;</strong><br>
					<a href="cart?action=addToCart&name=<%=app.getRef() %>" class="btn">Ajouter au panier</a>
					<br>
				</span>	
				
			<% i++; 
			} %>
			</p>	type filter text
		</div>	
		<div id="panier">
			<h3>Panier</h3>	
		<% if (session.getAttribute("cart") != null) { 
				ArrayList<cart> panier	= (ArrayList<cart>) session.getAttribute("cart");%>
				<table border=0 cellpacing=0 cellpadding=0>
					<tr><th>Item</th><th>Qte</th><th align="right">Prix &euro;</th></tr>
				<% float total = 0;
					for(cart pp : panier) {%>
					<tr>
						<td align="center"><%=pp.getItem().getRef() %></td>
						<td align="center"><%=pp.getQte() %></td>
						<td align="right"><%=pp.getItem().getPrice() %></td>
					</tr>
				<% float som = pp.getItem().getPrice();
				 total = total + som;
				} %> 
				</table>
				<br>
				total : <%=total %>
				<br>
				<a href="#">commander</a>
		<% }else{ %>
				panier vide
		<% } %>
		</div>
	</div>	
</body>
</html>