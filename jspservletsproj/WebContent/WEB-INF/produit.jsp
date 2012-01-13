<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="appContent" class="com.insia.beans.articleContent" scope="session"/>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
#menu li
{
	float:left;
	list-style-type:none;
	margin-left:10px;
}
#menu_produit
{
	width:100%;
}
#menu_prod img
{
	width:50px;
}
#menu_prod table
{
	cellspacing:0;
	cellpadding:0;
}
</style>

</head>
<body>
<%@ page import="com.insia.models.Articles" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="../menu.jsp" %>
<table id="menu_produit">

	<tr>
		<td>
			<div id="menu">
				<ul>
					<%for (Articles app : appContent.getArticles()) { %>
					<li>
						<img alt="<%=app.getIcon()%>" src="./WEB-IMG/<%=app.getIcon() %>"  />
						<br>
						<a href="app?action=details&name=<%=app.getNom() %>"><%=app.getNom() %></a>
						<br>
						Prix : <strong><%=app.getPrice() > 0 ? app.getPrice() : "Gratuit" %>&euro;</strong><br>
						<a href="cart?action=addToCart&name=<%=app.getNom() %>" class="btn">Ajouter au panier</a>
						<br>
					</li>
					<% 	} %>
				</ul>
			</div>
		</td>
	</tr>

</table>

</body>
</html>