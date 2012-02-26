<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jweb TP</title>
</head>
<body>

	<table style="border: solid 1px;">
		<th><span style="color:red;">MI SE EN OEUVRE DE SERVLET</span></th><th><span style="color:red;">COMMUNICATION ENTRE SERVLETS</span></th>
		<tr>
			<td>
				<table>
					<th>Exercice1</th><th>Exercice2</th>
					<tr>
						<td><a href="./boucle"><p>Activer la boucle</p></a></td>
						<td>
							<form action="./formulaire" method="post">
								<table>
									<tr>
										<td>Nom :</td><td><input type="text" name="nom"></td>
									</tr>
									<tr>
										<td>Prenom :</td><td><input type="text" name="prenom"></td>
									</tr>
									<tr>
										<td>Livre :</td><td><input type="text" name="livre"></td>
									</tr>
									<tr>
										<td>Catégorie :</td><td>
																<select name="cat">
																	<option value="fantastique">Fantastique</option>
																	<option value="humoristique">Humoristique</option>
																	<option value="aventure">Aventure</option>
																	<option value="policière">Policière</option>
																	<option value="autre">Autre</option>
																</select>
															</td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit" value="OK"></td>
									</tr>
								</table>
							</form>
						</td>
				</tr>
				</table>
			</td>
			
			
			<td>
				<table>
					<th>Exercice0</th><th>Exercice1</th><th>Exercice2</th>
					<tr>
						<td>
							<table>
								<tr>
									<td><p>Utilisation des balises context-param 
									<br/>dans le .xml avec les balisesparam-name 
									<br/>et param-value. Ces variables globales 
									<br/>seront récupérable dans une servlet ou une page jsp.
									<br/>
									<br/>Servlet: 
									<br/>_ServletContext x=getServletContext();
									<br/>_x.getInitParameter("[nomduParametreContext]");</p>
									<form action="./context" method="post">
									<input type="submit" value="Test">
									</form>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<% if( session.getAttribute("nom") !=null && session.getAttribute("prenom") !=null){ %>
							<%= "Bonjour ".toString()%>
							<%= session.getAttribute("nom").toString()%>
							<%= session.getAttribute("prenom").toString()%>
							<%} %>
							
							<form action="./session" method="post">
								<table>
								<br/>
									<tr>
										<td>Nom :</td><td><input type="text" name="nom"></td>
									</tr>
									<tr>
										<td>Prenom :</td><td><input type="text" name="prenom"></td>
									</tr>
									<tr>
										<td colspan="2" align="right"><input type="submit" value="OK"></td>
									</tr>
								</table>
							</form>
						</td>
						<td></td>
				</tr>
				</table>
			</td>
		</tr>
	</table>
	<a href="http://www.google.com/calendar/event?action=TEMPLATE&text=testputevent&dates=20120226/20120228&details=it's%20a%20little%20test&location=at%20home&trp=false&sprop=&sprop=name:" target="_blank"><img src="//www.google.com/calendar/images/ext/gc_button6.gif" alt="0" border="0"></a>
	<iframe src="https://www.google.com/calendar/embed?title=Calendar&amp;height=600&amp;wkst=1&amp;hl=fr&amp;bgcolor=%23FFFFFF&amp;src=phejar.manuel%40gmail.com&amp;color=%232952A3&amp;ctz=Europe%2FParis" style=" border-width:0 " width="800" height="600" frameborder="0" scrolling="no"></iframe>

</body>
</html>