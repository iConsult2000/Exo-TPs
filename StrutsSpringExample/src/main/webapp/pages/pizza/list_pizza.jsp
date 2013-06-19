<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="pages/css/style.css" />

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- begin container -->
<div class="container">
	<h1>Italia Pizzeria</h1>
<!-- begin section 1 -->
	<div class="contents1">
	
		<h2>Liste de toutes les pizzas</h2>
		
		<table border="1">
		<tr><th>Nom</th><th>Prix</th></tr>
		
		<logic:iterate id="pizza" name="dynaPizzaListForm" property="pizzaList">
		<tr>	
		<td><bean:write name="pizza" property="nom"/></td>
		<td><bean:write name="pizza" property="prix"/></td>
		
		</tr>
		</logic:iterate> 
		
		</table>
		
		<br/>
		<br/>
		<html:link action="/AddCustomerPage.do">Add Customer</html:link>
	</div>
	<!-- end section1 -->
 </div>
 <!-- end container -->

</body>
</html>