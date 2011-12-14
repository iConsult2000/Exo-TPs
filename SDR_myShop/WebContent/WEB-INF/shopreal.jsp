<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#item li {
	float: left;
	list-style-type: none;
	font-size: 1em;
	list-style-type: none;
}

#item input {
	margin-left: auto;
	margin-right: auto;
}

#item h3 {
	margin: auto;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	

	<div>

		<p />
		<center>
			<h3>Do your shopping</h3>
		</center>

		<ul id="item">
			<li><center><img src="./WEB-PNG/Iphone_4_blanc_medium.png"
				alt="Iphone_4_blanc" /> <br>  
				A partir de 250€	
			
			<%-- initialize bean properties --%>
				<jsp:useBean id="id001"	class="com.insia.org.servlets.MyBeans" scope="session" />
				<jsp:setProperty name="id001" property="item" value="iPhone4S" /> 
				<jsp:setProperty name="id001" property="prix" value="250" />
				<jsp:setProperty name="id001" property="description" value="iPhone 4S new" /> 
			
			<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id001" /></h3> 
				<form action="shopreal" method="get">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id001"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center>
			</li>
			
			<li><center><img src="./WEB-PNG/Curve-9360-front-medium.png" alt="shopping" /> <br>
			A partir de 745€
				<%-- intialize bean properties --%>
				<jsp:useBean id="id002"	class="com.insia.org.servlets.MyBeans" scope="session" />
					<jsp:setProperty name="id002" property="prix" value="745" />
					<jsp:setProperty name="id002" property="item"	value="Curve9360" />
					<jsp:setProperty name="id002" property="description" value="Black Berry Curve" />
				
			
			<%-- this body is executed only if the bean is created --%>	
				<h3><jsp:getProperty property="description" name="id002" /></h3> 
				<form action="shopreal" method="get">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id002"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center></li>
			
			<li><center><img src="./PNG/samsung-galaxy-note-medium_front..png" alt="shopping" /> <br>
			A partir de 15€
			<%-- intialize bean properties --%>
				<jsp:useBean id="id003" class="com.insia.org.servlets.MyBeans" scope="session" />
					<jsp:setProperty name="id003" property="prix" value="15" />
					<jsp:setProperty name="id003" property="item"	value="GalaxyNote" />
					<jsp:setProperty name="id003" property="description"	value="Galaxy note" />
				
			
			
				<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id003" /></h3> 
				<form action="shopreal" method="get">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id003"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
				</center>				
			</li>
			
			<li><center><img src="./PNG/nokia800-medium-front.png" alt="shopping" /> <br>
			A partir de 5€
								
				<%-- intialize bean properties --%>
				<jsp:useBean id="id004"	class="com.insia.org.servlets.MyBeans" scope="session" />
					<jsp:setProperty name="id004" property="prix" value="5" />
					<jsp:setProperty name="id004" property="item" value="nokia800" />
					<jsp:setProperty name="id004" property="description" value="nokia 800" />
				
				
				<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id004" /></h3> 
				<form action="shopreal" method="get">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id004"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			
			</center></li>
			
			
		<li><center><img src="./PNG/wave 3-medium-front.png" alt="shopping" /> <br>
		A partir de 75€
		
				<%-- intialize bean properties --%>
				<jsp:useBean id="id005"	class="com.insia.org.servlets.MyBeans" scope="session"/>
				<jsp:setProperty name="id005" property="prix" value="75" />
				<jsp:setProperty name="id005" property="item" value="wave 3" />
				<jsp:setProperty name="id005" property="description" value="wave3 desire" />
		
			
			<%-- this body is executed only if the bean is created --%>
				<h3><jsp:getProperty property="description" name="id005" /></h3> 
				<form action="shopreal" method="get">
					<input	id="userForm:btnOk" name="item" type="submit"		
					value="id005"	onclick="if (!confirm('This item will be added in cart')) return false;
									clear_userForm();" />
				</form>
			</center></li>

		</ul>


	</div>


</body>
</html>
