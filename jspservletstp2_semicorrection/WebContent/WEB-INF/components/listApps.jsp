<%@ page import="org.insia.models.App" %>
<jsp:useBean id="appContent" class="org.insia.beans.AppContent"/>

<div class="page-header">
	<h1>
		Liste des applications
	</h1>
</div>
<div class="row">
	<% for(App app : appContent.getApps()) { %>
	<div class="span5">
		<a href="app?action=details&name=<%=app.getName() %>">
			<img alt="<%=app.getName() %>" src="<%=app.getIcon()!=null && !app.getIcon().equals("") ? app.getIcon() : "resources/images/iDroidphone7.png"  %>" width="60"/>
			<h3><%=app.getName() %></h3>
		</a>
		<p>Prix : <strong><%=app.getPrice() > 0 ? app.getPrice() : "Gratuit" %></strong></p>
		<a href="cart?action=addToCart&name=<%=app.getName() %>" class="btn">Ajouter au panier</a>
	</div>
	<% } %>
</div>