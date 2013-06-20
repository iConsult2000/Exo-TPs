<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pizzeria.pizza.model.Pizza"%>
<%@page import="com.pizzeria.cart.model.PurchaseOrder"%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<jsp:useBean id="sessionCart" class="com.pizzeria.cart.model.Cart"
	scope="session" />
<div class="contents2">

	<h5>
		Mon panier :
		<%=sessionCart.getNbrearticles()%>
		articles
	</h5>

	<table>
		<tr>
			<th>Ref. article</th>
			<th>Désignation</th>
			<th>Prix</th>
			<th>Remise</th>
		</tr>
		<%
			float montant = 0;
			if (sessionCart.getListproduit().size() > 0) {
				for (Pizza produit : sessionCart.getListproduit()) {
					montant = montant + produit.getPrix();
		%>
		<tr>
			<td><a href=removeArticle?numeroArticle=<%=produit.getPizzaId()%>><%=produit.getPizzaId()%></a></td>
			
			<td><%=produit.getNom()%></td>
			<td><%=produit.getPrix()%></td>


		</tr>
		<%
			}
			}
		%>
		<tr>
			<td>Total</td>
			<td><%=montant %></td>

		</tr>
		<tr>
		<td>
		
		<form action=valOrder method="get">
					<label>Numero client :</label><input type="text" name="codeclient"/><br>
					<input id="userForm:btnOk" name="btnOk" type="submit"
						value="Valider"
						onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
		</form>
		
		</td>
		</tr>

	</table>
</div>