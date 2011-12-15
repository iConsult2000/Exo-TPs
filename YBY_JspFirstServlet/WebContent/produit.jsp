<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
<style type="text/css">
  #menu li {
  float: left;
  list-style-type:none;
  margin-left:10px;
 }
 

 </style>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<div>
		<h3>Liste de produits</h3>
	</div>
	
	<div id="liste">
	
	<jsp:useBean id="Produit" class="com.insia.org.beans.Produit">
		<jsp:setProperty name="Produit" property="libelle" value="Montre casio étanche"/>
		<jsp:setProperty name="Produit" property="prix" value="79"/>
	</jsp:useBean>
	
		Article <%= Produit.getLibelle()   %>
		<br>
		Prix <%= Produit.getPrix()   %>&euro;
		<form><input name="submit" type="submit" value="Ajouter"/>
	</form>	
	<br><br>
	
	<jsp:useBean id="article" class="com.insia.org.beans.Produit" scope="session"/>
	Article <%= article.getLibelle()   %>
	<br>
	Prix <%= article.getPrix()   %>&euro;
	<form><input name="submit" type="submit" value="Ajouter"/>
	</form>	
	</div>
	
	<div id="panier">
	</div>
	
	
</body>
</html>