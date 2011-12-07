<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#connexion p {

font-size: 14px;
}
#connexion label {
float:left;
width:70px;
}

</style>

</head>
<body>
<!-- Notre site possède un menu qui s'affiche sur toutes les pages du site ( indice : directive include ) -->
<%@ include file="Menu.jsp" %>

<div id="connexion">
		<br><br>
		<hr>
		<p>Connexion</p>
		<form method="post" action="login">
			<label>Login : </label><input type="text" name="myname"><br>
			<label>Passw : </label><input type="password" name="mypwd"><br>
			
			<label>&nbsp;</label><input type="submit" name="credential" value="Connexion">
			
		</form>
		
		
</div>	
</body>
</html>