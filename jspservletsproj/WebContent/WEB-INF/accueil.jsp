<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#menu li
{
	float:left;
	list-style-type:none;
	margin-left:10px;
}
table
{
	width:100%;
}

</style>
</head>
<body>
<%
	Cookie[] my_cookies = request.getCookies();

	if(my_cookies!=null){
		
		for(int i=0; i<my_cookies.length; i++)
		{
			if(my_cookies[i].getName().equals("cookie_login"))
			{
				session.setAttribute("login",my_cookies[i].getValue());
				
			}
		}
		
	}
%>
<%@ include file="../menu.jsp" %>
<table>
	<tr>
		<td>
			<a>Bienvenue sur ce site génialissime !</a>
		</td>
	</tr>
			<tr>
		<td>
			<a>Pour accéder à la page secrète, vous devez vous connecter !</a>
		</td>
	</tr>
	<tr>
		<td>
        	<%@ include file="/WEB-INF/produit.jsp" %>
		</td>
	</tr>
</table>

</body>
</html>