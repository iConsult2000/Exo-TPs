<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="pages/css/index.css" />

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Foody's Pizza</title>
</head>
<body>
<body style="background-color:#999;">
<div class="page">	

    <!-- begin header -->
        <div class="header">
			<jsp:include page="/pages/customer/menu.jsp" />
		</div>
	<!-- end header -->
 
    <div class="content">
    	<div class="left">
        	<div>
            	<h3>Panier</h3>
                Votre panier est vide
            </div>
            <div>
            	<h3>Meilleure vente de la semaine</h3>
            	-Pizza calzone<br>
                -Pizza orentale<br>
                -Pizza canibale<br>
            </div>
        </div>
        <div class="right">
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
			
        </div>
    </div>
    <div class="footer">By Iconsult2000 2013</div>
 </div>
</body>
</html>