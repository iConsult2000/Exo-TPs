<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./bookshop">bookshop</a>
<br/>
<% if(session.getAttribute("listeLibelles") != null || session.getAttribute("listePrix") != null){ %>
<p>Liste des articles :</p>
<%= session.getAttribute("listeLibelles").toString()%>
<br/>
<%= session.getAttribute("listePrix").toString()%>
<% } %>
</body>
</html>