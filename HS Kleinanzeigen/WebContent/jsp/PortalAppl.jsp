<%@page import="java.sql.SQLException"%>
<%@page import="de.hs_lu.bw4s.jdbc.NoConnectionException"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="lb" class="de.hs_lu.bw4s.beans.LoginBean" scope="session" />
<jsp:useBean id="mb" class="de.hs_lu.bw4s.beans.MessageBean" scope="session" />
<%
String logout   = request.getParameter("logout");
String target   = request.getParameter("target");
String comeFrom = request.getParameter("comeFrom");
if (logout == null) logout = "";
if (target == null) target = "";
if (comeFrom == null) comeFrom = "";

if (!lb.isLoggedIn()){
	mb.setGeneralWelcome();
	response.sendRedirect("./LoginAppl.jsp?comeFrom=PortalAppl");	
}else if (logout.equals("Abmelden")){
	lb.setLoggedIn(false);
	mb.setLogoutSuccessful();
	response.sendRedirect("./LoginAppl.jsp?comeFrom=PortalAppl");	
}else if(target.contains("Appl")){
	//UrlaubsAppl kann kein Messaging :-(
	response.sendRedirect("./" + target);	
	
}else if(comeFrom.contains("Appl")){
	// keine Message erforderlich
	response.sendRedirect("./PortalView.jsp");
}else{
	mb.setGeneralWelcome();
	response.sendRedirect("./LoginAppl.jsp?comeFrom=PortalAppl");	
}

%>
</body>
</html>