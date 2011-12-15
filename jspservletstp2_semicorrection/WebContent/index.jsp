<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://twitter.github.com/bootstrap/1.3.0/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<script type="text/javascript" src="resources/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-dropdown.js"></script>
<title>iDroid phone 7</title>
</head>
<body>
	<jsp:useBean id="userSession" class="org.insia.beans.UserSession"
		scope="session" />
		<jsp:useBean id="pageName" class="java.lang.String" scope="request"/>

	<jsp:include page="WEB-INF/components/menu.jsp" />

	<div class="container">



		<div class="content">
			<jsp:include page="WEB-INF/components/${pageName}" />
		</div>

		<footer>
			<p>&copy; Travaux pratiques - INGESUP - Doc4web</p>
		</footer>

	</div>
</body>
</html>