<%@page import="de.hs_lu.bw4s.beans.GUIBean"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="../CSS/LoginView.css" />
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
<div class="LoginViewCenter"> 
<table>
<tr ><td class="einloggen"> Einloggen </td></tr>
<tr> <td class="spacing"></td></tr>
<tr><td class="schrift">Nickname </td> </tr>
<tr>
	<td><input class="feld" 
				type="text"
				name="userid"
				value="<jsp:getProperty name='lb' property='userid' />"
		/>
	</td>
</tr>
<tr> <td class="spacing"></td></tr>
<tr><td class="schrift">Password </td> </tr>
<tr>
	<td><input class="feld" type="password" name="password" value="" /></td>
</tr>
<tr> <td class="spacing"></td></tr>
<tr>
<td>
	<input class="submit" type="submit" name="login" value="Login" />
</td>
<tr>
<td class="oder"> oder </td>
</tr>
<tr><td><a href="./LoginAppl.jsp?zurReg=zurReg">Registrieren</a></td> </tr>
</table>
 </div> 
</form>

</body>
</html>