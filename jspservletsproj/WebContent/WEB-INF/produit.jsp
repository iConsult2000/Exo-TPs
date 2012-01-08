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
<table id="menu_produit">

	<tr>
		<td>
			<div id="menu">
				<ul>
					<li>
						<table id="menu_prod">
						
							<jsp:useBean id="id0001" type="com.insia.beans.MyBeans" scope="session"/>
								<tr><td><img src="./WEB-IMG/ipad.png" alt="Ipad"/></td></tr>
								<tr><td><jsp:getProperty property="nomProduit" name="id0001"/></td></tr>
								<tr><td><jsp:getProperty property="prix" name="id0001"/></td></tr>
								<form action="produit" method="get">
									<tr><td><input type="hidden" name="item" value="id0001"></td></tr>
									<tr><td><input type="submit" value="Ajouter au panier"></td></tr>
								</form>
							
							<jsp:useBean id="id0002" type="com.insia.beans.MyBeans" scope="session"/>
								<tr><td><img src="./WEB-IMG/samsung-galaxy-note.jpg" alt="Samsung Note"/></td></tr>
								<tr><td><jsp:getProperty property="nomProduit" name="id0002"/></td></tr>
								<tr><td><jsp:getProperty property="prix" name="id0002"/></td></tr>
								<form action="produit" method="get">
									<tr><td><input type="hidden" name="item" value="id0002"></td></tr>
									<tr><td><input type="submit" value="Ajouter au panier"></td></tr>
								</form>
						
						</table>
					</li>
				</ul>
			</div>
		</td>
	</tr>

</table>

</body>
</html>