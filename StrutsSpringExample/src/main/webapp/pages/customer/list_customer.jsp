<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="pages/css/style.css" />

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


 
<html>
<head>
</head>
<body>
<!-- begin header -->
<div class="menu">
		<h1>Banniere d'accueil</h1>
		<ul>
			<li>Liste des catégories</li>
			<li>champ de saisie</li>
			<li>bouton rechercher</li>
			
		</ul>
		<a href="Login.do">Se connecter</a>

</div>

<!-- end header -->

<!-- begin container -->
<div class="container">
	<h1>Italia Pizzeria</h1>
<!-- begin section 1 -->
	<div class="contents1">
	
		<h2>Liste de tous les Pizzas</h2>
		
		<table border="1">
		<tr><th>Nom</th><th>Prénom</th><th>Téléphone</th><th>Adresse</th><th>Date de création</th></tr>
		
		<logic:iterate id="customer" name="dynaCustomerListForm" property="customerList">
		<tr>	
		<td><bean:write name="customer" property="name"/></td>
		<td><bean:write name="customer" property="firstname"/></td>
		<td><bean:write name="customer" property="tel"/></td>
		<td><bean:write name="customer" property="address"/></td>
		<td><bean:write name="customer" property="createdDate"/></td>
		
		</tr>
		</logic:iterate> 
		
		</table>
		
		<br/>
		<br/>
		<html:link action="/AddCustomerPage.do">Add Customer</html:link>
	</div>
	<!-- end section1 -->
                
    <!-- begin section 2 -->
           <!-- Le panier début -->
           <!-- Afficher uniquement si le client est authentifié -->
           <%
			if((String) session.getAttribute("sessionToken") == "valide") {
			%>
		    <div class="contents2">
		            <jsp:include page="/pages/customer/mycart_customer.jsp" />
		    </div>
		    <%} %>
            <!-- Le panier fin -->
    <!-- end section 2 -->

 </div>
 <!-- end container -->
 
 <!-- begin footer -->
 <div></div>
 <!-- end footer -->
 
</body>
</html>