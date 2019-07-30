<%@page import="de.hs_lu.bw4s.beans.GUIBean"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.AccountBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/BW4S.css" />
<script type="text/javascript" src="../js/BW4S.js" ></script>
</head>
<body>
<jsp:useBean id="ab" class="de.hs_lu.bw4s.beans.AccountBean" scope="session" />
<jsp:useBean id="mb" class="de.hs_lu.bw4s.beans.MessageBean" scope="session" />
<jsp:useBean id="gb" class="de.hs_lu.bw4s.beans.GUIBean" scope="session" />
<jsp:getProperty name="gb" property="headlineHtml" />

<h2><jsp:getProperty name="mb" property="infoMessage" /></h2>
<h4><jsp:getProperty name="mb" property="actionMessage" /></h4>

<form action="./RegAppl.jsp" method="get"
		onsubmit="return inputCheck(this)"
>
<table>
<tr>
	<td>Nickname: </td>
	<td><input type="text"
				name="userid"
				value="<jsp:getProperty name='ab' property='userid' />"
				onkeyup="checkAndMessageUserid(this.value)"
		/>
	</td>
	<td id="useridMsgField" class="fehler"></td>
</tr>
<tr>
	<td>Passwort:</td>
	<td><input type="password" name="password" value="" 
				onkeyup="checkAndMessagePassword(this.value)"
		/>
	</td>
	<td id="passwordMsgField" class="fehler"></td>
</tr>
<tr>
	<td>Username:</td>
	<td><input type="text"
				name="username"
				value="<jsp:getProperty name='ab' property='username' />"
		/>
	</td>
	<td id="usernameMsgField" class="fehler"></td>
</tr>
<tr>
	<td>E-Mail:</td>
	<td><input type="text"
				name="email"
				value="<jsp:getProperty name='ab' property='email' />" /></td>
	<td id="emailMsgField" class="fehler"></td>
</tr>
<tr>
<td></td>
<td>
	<input type="submit" name="register" value="Registrieren" 
		onclick="setButtonClicked(this)"
	/>
	<input type="submit" name="zumlogin" value="zum Login" 
		onclick="setButtonClicked(this)"
	/>
</td>
	<td></td>
</tr>
</table>

</form>


</body>
</html>