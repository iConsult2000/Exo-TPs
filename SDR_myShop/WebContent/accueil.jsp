<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="resources/css/style.css" />
	<title>e-Web-shopping SDR</title>

</head>
<body>
	<!-- Afficher la page de Menu après le test de cookies -->
	<div class="menu">	
		<jsp:include page="/WEB-INF/components/Menu.jsp" />
		<br>
		<hr>
		<p>Bienvenue sur ce site génialissime !</p>
		<p>Pour accéder à la page secrète, vous devez vous connecter !</p>
	</div>
	
	<div class="container">
		<h3>Create your account member</h3>
	
		<jsp:include page="/WEB-INF/components/dummyshop.jsp" />
		
	</div>
	<div class="footer">
		<br>
		<hr>
		<p> &copy; Travaux Pratiques Ingesup 2011 </p>
	
	</div>

</body>
</html>