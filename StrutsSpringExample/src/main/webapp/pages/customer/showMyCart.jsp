<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="pages/css/index.css" />
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
            	<h3>Meilleure vente de la semaine</h3>
            	-Pizza calzone<br>
                -Pizza orentale<br>
                -Pizza canibale<br>
            </div>
        </div>
        <div class="right">
        	<h2>Votre panier</h2>		
			 <jsp:include page="/pages/customer/mycart_customer.jsp" />
        </div>
    </div>
    <div class="footer">By Iconsult2000 2013</div>
 </div>
</body>
</html>