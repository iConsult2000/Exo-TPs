<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>


	<div>
		<%
			if (session.getAttribute("login") != null) {
		%>
		<%@ page import="com.insia.org.servlets.FakeDataHolder"%>
		<%@ page import="com.insia.org.servlets.MyBeans"%>
		<%@ page import="java.util.List"%>
		<%
			FakeDataHolder database = FakeDataHolder.getInstance();

				// Recuperation du panier. CreateTable retourne une Liste d'objet
				List<MyBeans> products = (List<MyBeans>) database
						.createTable("Basket");
				products = (List<MyBeans>) database.get("Basket");
		%>

		<ul id="item">
			<li><jsp:useBean id="myiPhone4S"
					class="com.insia.org.servlets.MyBeans" scope="session">
					<%-- this body is executed only if the bean is created --%>
					<center>
						<h3>Protege iPhone4S</h3>
						<img src="./img/iPhone4S.jpg" alt="shopping" /> <br>
						<center>
						

							<input id="userForm:btnOk" name="userForm:btnOk" type="submit"
								value="Add to cart"
								onclick="if (!confirm('This item will has been added')) return false;
								clear_userForm();" />

						</center>
						<%-- intialize bean properties --%>
						<jsp:setProperty name="myiPhone4S" property="prix" value="250" />
						<jsp:setProperty name="myiPhone4S" property="item"
							value="iPhone4S" />
						<jsp:setProperty name="myiPhone4S" property="description"
							value="Latest iPhone technology" />
				</jsp:useBean></li>




			<li><jsp:useBean id="myAcerTabPc"
					class="com.insia.org.servlets.MyBeans" scope="session">
					<%-- this body is executed only if the bean is created --%>
					<center>
						<h3>Acer Tablet pc</h3>
						<img src="./png/acer_iconia_tab.png" alt="shopping" /> <br>
						<center>
							<input type="Button" id="btnPrint" onClick="window.print()"
								value="Add to cart" />
						</center>
						<%-- intialize bean properties --%>
						<jsp:setProperty name="myAcerTabPc" property="prix" value="745" />
						<jsp:setProperty name="myAcerTabPc" property="item"
							value="AcerTabPc" />
						<jsp:setProperty name="myAcerTabPc" property="description"
							value="Acer Tablet pc" />
				</jsp:useBean></li>
			<li><jsp:useBean id="my3G_model1"
					class="com.insia.org.servlets.MyBeans" scope="session">
					<%-- this body is executed only if the bean is created --%>
					<center>
						<h3>Cle internet 3G</h3>
						<img src="./png/Cle_internet_3G_model1.png" alt="shopping" /> <br>

						<input type="Button" id="btnPrint" onClick="window.print()"
							value="Add to cart" />
					</center>
					<%-- intialize bean properties --%>
					<jsp:setProperty name="my3G_model1" property="prix" value="15" />
					<jsp:setProperty name="my3G_model1" property="item"
						value="3G_model1" />
					<jsp:setProperty name="my3G_model1" property="description"
						value="Cle internet 3G" />
				</jsp:useBean></li>

			<li><jsp:useBean id="my3G_model2"
					class="com.insia.org.servlets.MyBeans" scope="session">
					<%-- this body is executed only if the bean is created --%>
					<center>
						<h3>Cle internet 3G+</h3>
						<img src="./png/Cle_internet_3G_model2.png" alt="shopping" /> <br>

						<input type="Button" id="btnPrint" onClick="addBasket()"
							value="Add to cart" />
					</center>
					<%-- intialize bean properties --%>
					<jsp:setProperty name="my3G_model2" property="prix" value="5" />
					<jsp:setProperty name="my3G_model2" property="item"
						value="3G_model2" />
					<jsp:setProperty name="my3G_model2" property="description"
						value="Cle internet 3G+" />
				</jsp:useBean></li>
			<li><jsp:useBean id="myGalaxyTabPc"
					class="com.insia.org.servlets.MyBeans" scope="session">
					<%-- this body is executed only if the bean is created --%>
					<center>
						<h3>Galaxy tablet pc</h3>
						<img src="./png/samsung_galaxy_tab.png" alt="shopping" /> <br>
						<input type="Button" id="btnPrint" onClick="window.print()"
							value="Add to cart" />
					</center>
					<%-- intialize bean properties --%>
					<jsp:setProperty name="myGalaxyTabPc" property="prix" value="75" />
					<jsp:setProperty name="myGalaxyTabPc" property="item"
						value="GalaxyTabPc" />
					<jsp:setProperty name="myGalaxyTabPc" property="description"
						value="Galaxy tablet pc" />
				</jsp:useBean></li>

		</ul>
		<%
			}
		%>

	</div>
</body>
</html>
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