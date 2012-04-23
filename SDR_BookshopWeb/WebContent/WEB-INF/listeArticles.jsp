<%@page import="java.util.ArrayList"%>
<%@page import="com.bookshop.persistance.Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="sessionStock" class="com.bookshop.models.StoreMag"
	scope="session" />




<div class="contents1">
	<p>Panel of the Supermarket</p>


	<table border=1px color=red cellpadding=0 cellspacing=0>
		<tr>
			<td>Reference_Produit</td>
			<td>Designation</td>
			<td>Prix</td>
			<td>Categorie</td>

		</tr>
		<%
			for (Produit myprod : sessionStock.getStore()) {
		%>
		<tr>
			<td><%=myprod.getRef_produit()%></td>
			<td><%=myprod.getNom_produit()%></td>
			<td><%=myprod.getPrix_unitaire()%></td>
			<td><%=myprod.getCode_categorie()%></td>
			<td><form action=addArticle method="get">
					<input type="hidden" name="nomArticle" value="<%=myprod.getNom_produit()%>"></input>
					<input type="hidden" name="numeroArticle" value="<%=myprod.getRef_produit()%>">
					<input id="userForm:btnOk" name="btnOk" type="submit"
						value="add to cart"
						onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
				</form></td>
		</tr>


		<%
			}
		%>

	</table>

</div>




