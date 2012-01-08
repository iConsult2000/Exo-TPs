<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
#menu_accueil li
{
	float:left;
	list-style-type:none;
	margin-left:10px;
}
#menu_accueil ul
{
		text-align:right;
}
#menu_tab
{
	width:100%;
	background-color: black;
	border-style:solid;
	border-width:1px;
}
</style>

</head>
<body>
<table id="menu_tab">

	<tr>
		<td>
			<div id="menu_accueil">
				<ul>
					<li><a href="./accueil.jsp">Accueil</a></li>
					<li>-</li>
					<% if(session.getAttribute("login")!=null){ %>
					<li><a href="./deconnexion">Déconnexion</a></li>
					<li>-</li>
					<li><a href="./produit">Produit</a></li>
					<li>|</li>
					<li>Connecté sous <%=session.getAttribute("login").toString() %></li>
					<% }else{ %>
					<li><a href="./connexion.jsp">Connexion</a></li>
					<%} %>
				</ul>
			</div>
		</td>
	</tr>

</table>

</body>
</html>