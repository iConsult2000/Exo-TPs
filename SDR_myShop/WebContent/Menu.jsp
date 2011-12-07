<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional //EN" "http://www.w3.org/TR/html4/loose.dtd">


<style type="text/css">
#menu li {
float:left;
margin-left: 10px;
list-style-type:none;
font-size: 1em;
}
</style>
<div id="menu">
		<ul> <%if (session.getAttribute("login") != null) { %>
			<li><a href="accueil.jsp">Accueil</a></li>
			<li> - </li>			
		
			<li><a href="logout">Deconnexion</a></li>
			<li> - </li>
			    
			<li><a href="">Information membre</a></li>
			<li> | </li>
			
			<li> Connecté sous <%=session.getAttribute("login").toString() %> </li>
			
			<%} else {%>
			<li><a href="accueil.jsp">Accueil</a></li>
			<li> - </li>			
		
			<li><a href="login.jsp">Connexion</a></li>
			<li> - </li>  
			<%} %>
			
		</ul>
</div>