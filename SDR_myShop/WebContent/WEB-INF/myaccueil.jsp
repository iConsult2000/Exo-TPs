<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Web-shopping SDR</title>

</head>
<body>
	<!-- Notre site possède un menu qui s'affiche sur toutes les pages du site ( indice : directive include ) -->




	<%
		Cookie[] mesCookies = request.getCookies(); // Je récupère tous les cookies

		if (mesCookies != null) {
			for (int i = 0; i < mesCookies.length; i++) {
				// S'il existeun Cookie nommé“nomCookie"
				if (mesCookies[i].getName().equals("logcookie1")) {
					// J’ai trouvéle cookie que je cherchais, je garde sa valeur:
					String login = mesCookies[i].getValue();

					//3. Mise en attribut de session des param requetes
					session.setAttribute("login", login);

				}
			}
		}
	%>
	<!-- Afficher la page de Menu après le test de cookies -->
	<%@ include file="../Menu.jsp"%>
	<div>
		<br> <br>
		<hr>
		<p>Bienvenue sur ce site génialissime !</p>
		<p>Pour accéder à la page secrète, vous devez vous connecter !</p>

	</div>
	<div>
	
		<%@ include file="/WEB-INF/shopreal.jsp" %>
		
	
		
	</div>
</body>
</html>