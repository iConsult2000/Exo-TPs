<%@page import="org.insia.beans.Message"%>
<div class="page-header">
	<h1>Inscription</h1>
</div>

<jsp:useBean id="errors" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="userBean" class="org.insia.models.User" scope="request" />
<jsp:setProperty property="*" name="userBean"/>

<%
	if (!errors.isEmpty()) {
		for (Object e : errors) {
			Message em = (Message) e;
%>
<div class="alert-message error">
	<p>
		<%=em.getContent() %>
	</p>
</div>


<%
	}
	}
%>

<form method="post" action="register">
	<fieldset>
		<div class="clearfix">
			<label for="login">Login</label>
			<div class="input">
				<input type="text" name="login" id="login" class="xmedium" value="${ userBean.login }" />
			</div>
		</div>
		<div class="clearfix">
			<label for="password">Mot de passe</label>
			<div class="input">
				<input type="password" name="password" id="password" class="xmedium" value="${ userBean.password }" />
			</div>
		</div>
		<div class="clearfix">
			<label for="confirmPassword">Confirmez le mot de passe</label>
			<div class="input">
				<input type="password" name="confirmPassword" id="confirmPassword" class="xmedium" />
			</div>
		</div>
		<div class="actions">
			<input type="submit" value="Valider" class="btn primary" />
		</div>
	</fieldset>
</form>
