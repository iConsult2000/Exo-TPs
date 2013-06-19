
<div class="menu">

<!-- begin menu -->
		<h1>Banniere d'accueil</h1>
		<ul>
			<li>Liste des catégories</li>
			<li>champ de saisie</li>
			<li>bouton rechercher</li>
			
		</ul>
		
		 <% if((String) session.getAttribute("sessionToken") == "invalide") { %>
		    <a href="Login.do">Se connecter</a>
		   <% } else { %>
		    <a href="Logout.do">Fermer la session</a>
		    <% } %>
		    
		    <!-- end menu -->
</div>