<%@page import="java.util.*"%>
<%@page import="org.insia.models.MyBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="contents">


	<h3>Do your shopping</h3>


	<ul class="item">
		<li>
			<%-- initialize bean properties --%> <jsp:useBean id="id001"
				type="org.insia.models.MyBeans" scope="session" /> <img
			src="./resources/PNG/Iphone_4_blanc_medium.png" alt="Iphone_4_blanc" />
			<br> <jsp:getProperty name="id001" property="prix" /> Euros <%-- this body is executed only if the bean is created --%>
			<h3>
				<jsp:getProperty property="description" name="id001" />
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id001"> <input
					id="userForm:btnOk" name="item" type="submit" value="id001"
					onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
			</form>
		</li>

		<li>
			<%-- intialize bean properties --%> <jsp:useBean id="id002"
				type="org.insia.models.MyBeans" scope="session" /> <img
			src="./resources/PNG/Curve-9360-front-medium.png" alt="shopping" />
			<br> <jsp:getProperty name="id002" property="prix" /> Euros <%-- this body is executed only if the bean is created --%>
			<h3>
				<jsp:getProperty property="description" name="id002" />
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id002"> <input
					id="userForm:btnOk" name="btnOk" type="submit" value="add to cart"
					onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
			</form>
		</li>

		<li>
			<%-- intialize bean properties --%> <jsp:useBean id="id003"
				type="org.insia.models.MyBeans" scope="session" /> <img
			src="./resources/PNG/samsung-galaxy-note-medium_front..png"
			alt="shopping" /> <br> <jsp:getProperty name="id003"
				property="prix" /> Euros <%-- this body is executed only if the bean is created --%>
			<h3>
				<jsp:getProperty property="description" name="id003" />
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id003"> <input
					id="userForm:btnOk" name="btnOk" type="submit" value="add to cart"
					onclick="if (!confirm('This item will be added in cart')) return false;
										clear_userForm();" />
			</form>

		</li>

		<li>
			<%-- intialize bean properties --%> <jsp:useBean id="id004"
				type="org.insia.models.MyBeans" scope="session" /> <img
			src="./resources/PNG/nokia800-medium-front.png" alt="shopping" /> <br>
			<jsp:getProperty name="id004" property="prix" /> Euros <%-- this body is executed only if the bean is created --%>
			<h3>
				<jsp:getProperty property="description" name="id004" />
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id004"> <input
					id="userForm:btnOk" name="btnOk" type="submit" value="Add to cart"
					onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
			</form>

		</li>


		<li>
			<%-- intialize bean properties --%> <jsp:useBean id="id005"
				type="org.insia.models.MyBeans" scope="session" /> <img
			src="./resources/PNG/wave 3-medium-front.png" alt="shopping" /> <br>
			<jsp:getProperty name="id005" property="prix" /> Euros <%-- this body is executed only if the bean is created --%>
			<h3>
				<jsp:getProperty property="description" name="id005" />
			</h3>
			<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id005"> <input
					id="userForm:btnOk" name="btnOk" type="submit" value="Add to cart"
					onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
			</form>
		</li>

	</ul>
	

</div>


<div class="cart">
	<p>Panel of the shop-cart</p>
	
	
	<table border=1px color=red cellpadding=0 cellspacing=0>
		<tr>
			<td>My-selected_item</td>
			<td>the price</td>

		</tr>
		<tr>
			<td>My-selected_item</td>
			<td>the price</td>

		</tr>
	</table>
	
</div>