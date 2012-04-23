<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bookshop.persistance.Produit"%>
<%@page import="com.bookshop.persistance.DetailsCommande"%>
<jsp:useBean id="sessionCart" class="com.bookshop.models.Cart"
	scope="session" />

<div class="contents2">
	<h5>
		Mon panier :
		<%=sessionCart.getNbrearticles()%>
		articles
	</h5>

	<table>
		<tr>
			<td>Ref. article</td>
			<td>Désignation</td>
			<td>Prix</td>
			<td>remise</td>

		</tr>
		<%
			if (sessionCart.getListproduit().size() > 0) {
				for (Produit produit : sessionCart.getListproduit()) {
		%>
		<tr>
			<td><a href=removeArticle?numeroArticle=<%=produit.getRef_produit()%>><%=produit.getRef_produit()%></a></td>
			
			<td><%=produit.getNom_produit()%></td>
			<td><%=produit.getPrix_unitaire()%></td>


		</tr>
		<%
			}
			}
		%>
		<tr>
			<td>Total</td>
			<td>non implemente</td>

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