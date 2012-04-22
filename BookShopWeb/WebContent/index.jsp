<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<br/>
<% if(session.getAttribute("ListArticles") != null){ %>
<p>Liste des articles :</p>
<table border="1px" cellspcing="0px" cellpadding="0px" width="700px">
	<th>Numéro</th>
	<th>Libèlle</th>
	<th>Prix</th>

</table>
<% } %>

<!-- <form action="./ajouter" method="post">
	<table>
		<th>Libelle</th>
		<th>Prix</th>
		<tr>
			<td><input type="text" name="libelle"/></td>
			<td><input type="text" name="prix"/></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="valider"/></td></tr>
	</table>
</form> -->
</body>
</html>