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
    
         <!-- Afficher uniquement si le client est authentifié  sessionTocken = "valide"-->
         
             <!-- start section 1 -->
           <%
			if((String) session.getAttribute("sessionToken") == "valide") {
			%>
			
    	<div class="left">
				<table border="1">
					<tr>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Téléphone</th>
						<thLogout.do?endSession=>Adresse</th>
						<th>Date de création</th>
					</tr>

					<logic:iterate id="customer" name="dynaCustomerListForm"
						property="customerList">
						<tr>
							<td><bean:write name="customer" property="name" /></td>
							<td><bean:write name="customer" property="firstname" /></td>
							<td><bean:write name="customer" property="tel" /></td>
							<td><bean:write name="customer" property="address" /></td>
							<td><bean:write name="customer" property="createdDate" /></td>

						</tr>
					</logic:iterate>

				</table>
			</div>
       <!-- end section1 -->
                
    <!-- begin section 2 -->
         <div class="right">
        	<jsp:include page="/pages/customer/mycart_customer.jsp" />

        </div>
   <!-- end section 2 -->    
           <%} %>
            
    </div>
    <div class="footer">By Iconsult2000 2013</div>
 </div>
</body>
</html>