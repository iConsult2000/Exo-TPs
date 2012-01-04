
		<ul> <%if (session.getAttribute("login") != null) { %>
			<li><a href="./accueil.jsp">Accueil</a></li>
			<li> - </li>			
		
			<li><a href="logout">Deconnexion</a></li>
			<li> - </li>
			    
			<li><a href="">Information membre</a></li>
			<li> | </li>
			
			<li> Connecté sous <%=session.getAttribute("login").toString() %> </li>
			
			<%} else {%>
			<li><a href="./accueil.jsp">Accueil</a></li>
			<li> - </li>			
		
			<li><a href="./login.jsp">Connexion</a></li>
			<li> - </li>  
			<%} %>
			
		</ul>
