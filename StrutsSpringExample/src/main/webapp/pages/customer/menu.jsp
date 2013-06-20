<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<!-- begin menu -->
				
		 <% if((String) session.getAttribute("sessionToken") == "invalide") { %>
		    <a href="Login.do">Se connecter</a>
		    <html:link action="/AddCustomerPage.do">Cr&eacute;ez un compte</html:link>
		   <% } else { %>
		   <a href="ListCustomer.do">Vos informations personnelles</a><br/>
		    <a href="Logout.do?endSession=true">Fermer la session</a>
		    <% } %>
		    
		    
 <!-- end menu -->
