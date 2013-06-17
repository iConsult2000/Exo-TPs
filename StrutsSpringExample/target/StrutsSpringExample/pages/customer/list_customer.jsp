<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<html>
<head>
</head>
<body>
<h1>Italia Pizzeria</h1>

<h2>Liste de tous les Clients</h2>

<table border="1">
<tr><th>Nom</td><td>Prénom</td><td>Téléphone</td><td>Adresse</td><td>Date de création</td></tr>

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
 
</body>
</html>