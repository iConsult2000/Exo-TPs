<%@page import="java.util.*"%>
<%@page import="org.insia.models.Product"%>
<%@page import="org.insia.beans.CartContent"%>
<jsp:useBean id="storedProducts" class="org.insia.beans.ProductContent"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="contents">
	<h3>Do your shopping</h3>

	<ul class="item">
	<% for (Product product : storedProducts.getProducts()) { %>
	
		<li>
			<%-- initialize bean properties --%>
			 <img alt="<%=product.getItem() %>" src="./resources/PNG/<%=product.getIcon() %>"  />
			<br> <%=product.getPrix() %> Euros 
			
			<%-- this body is executed only if the bean is created --%>
			<h3>
				<%=product.getDescription() %>
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="<%=product.getItem() %>"> <input
					id="userForm:btnOk" name="btnOk" type="submit" value="add to cart"
					onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
			</form>
		</li>
	<% } %>
		
	</ul>
	

</div>


<div class="cart">
	<p>Panel of the shop-cart</p>
	
	
	<table border=1px color=red cellpadding=0 cellspacing=0>
		<tr>
			<td>My-selected_item</td>
			<td>the price</td>

		</tr>
		<%if (((CartContent) session.getAttribute("cart")).getProduct() != null ) { for (Product product : ((CartContent) session.getAttribute("cart")).getProduct()) { %> 
		<tr>
			<td><%=product.getDescription() %></td>
			<td><%=product.getPrix() %></td>

		</tr>
		<% } } %>
		<tr>
			<td>Total </td>
			<td><%=((CartContent) session.getAttribute("cart")).getAmount() %></td>

		</tr>
		
	</table>
	
</div>