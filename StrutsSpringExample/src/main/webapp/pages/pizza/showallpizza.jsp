<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
			
			<table border="0px" cellpadding="0px" align="center" cellspacing="Opx">
			<tr><th>Nom</th><th>Prix</th></tr>
			
			<logic:iterate id="pizza" name="dynaPizzaListForm" property="pizzaList">
			<tr>	
				<td width="180px"><bean:write name="pizza" property="nom"/></td>
				<td width="80px"><bean:write name="pizza" property="prix"/></td>
				<td>
					<form action=addArticle.do method="get">
					<input type="hidden" name="nomArticle" value="<bean:write name="pizza" property="nom" />" />
					<input id="userForm:btnOk" name="btnOk" type="submit"
						value="Ajoutez au panier"
						onclick="if (!confirm('Cet article sera ajout�)) return false;
										clear_userForm();" />
					</form>
				</td>
			</tr>
			</logic:iterate> 
			
			</table>