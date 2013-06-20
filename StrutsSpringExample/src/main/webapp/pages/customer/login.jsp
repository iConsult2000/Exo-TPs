<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
 
<html>
<head>
</head>
<body>

<h2>Login</h2>
<div style="color:red">
	<html:errors/>
</div>

<form method="POST" action='<%= response.encodeURL("j_security_check") %>'>

<div style="padding:16px">
	<div style="float:left;width:100px;">
		Nom d'utilisateur : 
	</div> 
 
	<input type="text" name="j_username">
</div>

<div style="padding:16px">
	<div style="float:left;width:100px;">
		Mot de passe : 
	</div> 
 
	<input type="password" name="j_password">
</div>
 
<div style="padding:16px">
	<div style="float:left;padding-right:8px;">
		<html:submit>
             <bean:message key="customer.label.button.submit" />
        </html:submit>
	</div>
	<html:reset>
          <bean:message key="customer.label.button.reset" />
     </html:reset>
</div>
 
</form>
 
</body>
</html>
