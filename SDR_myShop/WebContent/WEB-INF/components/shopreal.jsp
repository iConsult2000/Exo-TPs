<%@page import="java.util.*"%>
<%@page import="org.insia.models.MyBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#item li {
	float: left;
	list-style-type: none;
	font-size: 1em;
	list-style-type: none;
}

#item input {
	margin-left: auto;
	margin-right: auto;
}

#item h3 {
	margin: auto;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<div id="core">

		<p />
		<center>
			<h3>Do your shopping</h3>
		</center>

		<ul id="item">
			<li><center>
			<%-- initialize bean properties --%>
				<jsp:useBean id="id001"	type="org.insia.models.MyBeans" scope="session" />
				<img src="./WEB-PNG/Iphone_4_blanc_medium.png" alt="Iphone_4_blanc" /> <br>  
				<jsp:getProperty name="id001" property="prix"  /> Euros
				 			
			<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id001" /></h3> 
				<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id001">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id001"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center>
			</li>
			
			<li><center>
			<%-- intialize bean properties --%>
				<jsp:useBean id="id002"	type="org.insia.models.MyBeans" scope="session" />
				<img src="./WEB-PNG/Curve-9360-front-medium.png" alt="shopping" /> <br>
			<jsp:getProperty name="id002" property="prix" /> Euros
				
			<%-- this body is executed only if the bean is created --%>	
				<h3><jsp:getProperty property="description" name="id002" /></h3> 
				<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id002">
					<input	id="userForm:btnOk" name="btnOk" type="submit"		
					value="add to cart"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center></li>
			
			<li><center>
			<%-- intialize bean properties --%>
				<jsp:useBean id="id003" type="org.insia.models.MyBeans" scope="session" />
				<img src="./PNG/samsung-galaxy-note-medium_front..png" alt="shopping" /> <br>
			<jsp:getProperty name="id003" property="prix"  /> Euros
					
				<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id003" /></h3> 
				<form action="shopreal" method="get">
				<input type="hidden" name="item" value="id003">
					<input	id="userForm:btnOk" name="btnOk" type="submit"		
					value="add to cart"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
				</center>				
			</li>
			
			<li><center>
			<%-- intialize bean properties --%>
			<jsp:useBean id="id004"	type="org.insia.models.MyBeans" scope="session" />
			<img src="./PNG/nokia800-medium-front.png" alt="shopping" /> <br>
			<jsp:getProperty name="id004" property="prix"  /> Euros
							
				<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id004" /></h3> 
				<form action="shopreal" method="get">
					<input type="hidden" name="item" value="id004">
					<input	id="userForm:btnOk" name="btnOk" type="submit"		
					value="Add to cart"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			
			</center></li>
			
			
		<li><center>
		<%-- intialize bean properties --%>
		<jsp:useBean id="id005"	type="org.insia.models.MyBeans" scope="session"/>
			<img src="./PNG/wave 3-medium-front.png" alt="shopping" /> <br>
			<jsp:getProperty name="id005" property="prix" /> Euros
		
			<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id005" /></h3> 
				<form action="shopreal" method="get">
					<input type="hidden" name="item" value="id005">
					<input	id="userForm:btnOk" name="btnOk" type="submit"		
					value="Add to cart"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center></li>

		</ul>


	</div>

<div id="core">
<table border=1px color=red cellpadding=0 cellspacing=0>
	<tr><td>mm</td><td>pp</td>
	
	</tr>
</table>

</div>

</body>
</html>
