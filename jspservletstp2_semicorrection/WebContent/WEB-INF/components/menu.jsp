<jsp:useBean id="userSession" class="org.insia.beans.UserSession"
	scope="session" />

<div class="topbar">
	<div class="fill">
		<div class="container">
			<img style="float: left" alt="logo"
				src="resources/images/logo_small.png" /> <a href="#" class="brand">
				iDroid phone 7 </a>
			<ul class="nav">
				<li
					class="${ pageContent.pageName == 'listApps.jsp' ? 'active' : '' }"><a
					href="index">Accueil</a></li>
				<%
					if (!userSession.isConnected()) {
				%>
				<li
					class="${ pageContent.pageName == 'register.jsp' ? 'active' : '' }"><a
					href="register">S'enregistrer</a></li>
				<li><a href="#" onclick="$('#login-form').show();">Connexion</a></li>
				<%
					} else {
				%>
				<li
					class="${ pageContent.pageName == 'createApp.jsp' ? 'active' : '' }"><a
					href="createApp">Ajouter une application</a></li>
				<%
					}
				%>
			</ul>

			<%
				if (!userSession.isConnected()) {
			%>
			<form id="login-form" class="pull-right" style="display: none;"
				method="post" action="login">
				<input name="login" type="text" placeholder="Identifiant"
					class="input-small"> <input name="password" type="password"
					placeholder="Mot de passe" class="input-small">
				<button type="submit" class="btn">Connexion</button>
			</form>
			<%
				} else {
			%>
			<ul class="nav secondary-nav">
				<li class="dropdown" data-dropdown="dropdown"><a
					class="dropdown-toggle" href="#">Connecté sous <strong>${
							userSession.userLogged.login }</strong>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profil</a></li>
						<li class="divider"></li>
						<li><a href="logout">Déconnexion</a></li>
					</ul></li>
			</ul>


			<%
				}
			%>
		</div>
	</div>
</div>
