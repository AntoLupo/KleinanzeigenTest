<%@page import="de.hs_lu.bw4s.beans.GUIBean"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BW4S-Portal-Login</title>


</head>
<body>
<jsp:useBean id="lb" class="de.hs_lu.bw4s.beans.LoginBean" scope="session" />
<jsp:useBean id="mb" class="de.hs_lu.bw4s.beans.MessageBean" scope="session" />
<jsp:useBean id="gb" class="de.hs_lu.bw4s.beans.GUIBean" scope="session" />
<jsp:getProperty name="gb" property="headlineHtml" />

<h2><jsp:getProperty name="mb" property="infoMessage" /></h2>
<h4><jsp:getProperty name="mb" property="actionMessage" /></h4>

<form action="./LoginAppl.jsp" method="get">
<table>
<tr>
	<td>Nickname: </td>
	<td><input type="text"
				name="userid"
				value="<jsp:getProperty name='lb' property='userid' />"
		/>
	</td>
</tr>
<tr>
	<td>Passwort:</td>
	<td><input type="password" name="password" value="" /></td>
</tr>
<tr>
<td></td>
<td>
	<input type="submit" name="login" value="Login" />
</td>
</tr>
</table>
</form>
Noch kein Nickname? Registrieren Sie sich 
<a href="./LoginAppl.jsp?zurReg=zurReg">hier</a>.

</body>
</html>