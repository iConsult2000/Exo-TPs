<div id="menu">
		<ul>
			<li><a href="accueil.jsp">Accueil</a></li>			
			<% if (session.getAttribute("nom") != null) { %> 
			<li><a href="produit.jsp">Produits</a></li>
			<li><a href="logout"> D�connexion</a></li> 
			<li><a href="info">Information </a></li>
			<li>| Connect� sous <%= session.getAttribute("nom").toString()%></li>
			<% }else{ %>
			<li><a href="connexion.jsp">Connexion</a></li>
			<%} %>
		</ul>
	</div>