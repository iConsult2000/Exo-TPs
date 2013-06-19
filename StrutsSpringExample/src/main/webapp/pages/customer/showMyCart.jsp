<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Italia Pizzeria - Votre panier</title>
</head>
<body>

<!-- begin header -->

	<jsp:include page="/pages/customer/menu.jsp" />
<!-- end header -->

<!-- begin container -->
<div class="container">
	<h1>Italia Pizzeria</h1>
<!-- begin section 1 -->
	
                
    <!-- begin section 2 -->
           <!-- Le panier début -->
           <!-- Afficher uniquement si le client est authentifié  sessionTocken = "valide"-->
           <%
			if((String) session.getAttribute("sessionToken") == "invalide") {
			%>
		    <div class="contents1">
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