<%@page import="de.hs_lu.bw4s.beans.GUIBean"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.LoginBean"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BW4S-Portal</title>


<jsp:useBean id="lb" class="de.hs_lu.bw4s.beans.LoginBean" scope="session" />
<jsp:getProperty name="lb" property="loginCheckRedirectHtml" />


</head>
<body>
<jsp:useBean id="mb" class="de.hs_lu.bw4s.beans.MessageBean" scope="session" />
<jsp:useBean id="gb" class="de.hs_lu.bw4s.beans.GUIBean" scope="session" />

<%
// if (!lb.isLoggedIn()) response.sendRedirect("./PortalAppl.jsp");
%>


<jsp:getProperty name="gb" property="headlineHtml" />

<h2><jsp:getProperty name="mb" property="infoMessage" /></h2>
<h4><jsp:getProperty name="mb" property="actionMessage" /></h4>


<form action="./PortalAppl.jsp" method="get">
	<input type="submit" name="logout" value="Abmelden" />
</form>

</body>
</html>