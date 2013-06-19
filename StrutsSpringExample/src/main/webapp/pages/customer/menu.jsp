


<!-- begin menu -->
				
		 <% if((String) session.getAttribute("sessionToken") == "valide") { %>
		    <a href="Login.do">Se connecter</a>
		   <% } else { %>
		    <a href="Logout.do">Fermer la session</a>
		    <% } %>
 <!-- end menu -->
