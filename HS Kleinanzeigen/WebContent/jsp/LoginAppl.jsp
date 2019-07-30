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
String userid   = request.getParameter("userid");
String password = request.getParameter("password");
String login    = request.getParameter("login");
String zurReg   = request.getParameter("zurReg");
String comeFrom = request.getParameter("comeFrom");
if (login == null) login = "";
if (zurReg == null) zurReg = "";
if (comeFrom == null) comeFrom = "";

if (login.equals("Login")){
	lb.setUserid(userid);
	lb.setPassword(password);
	try{
		boolean useridPasswordExistiert = lb.checkUseridPasswort();
		if(useridPasswordExistiert){//Userid/Password existiert (Login ok)
			
			lb.setLoggedIn(true);
			mb.setLoginSuccessful(userid);
			response.sendRedirect("./PortalAppl.jsp?comeFrom=LoginAppl");
		
		}else{
			lb.setLoggedIn(false);
			mb.setLoginFailed();
			response.sendRedirect("./LoginView.jsp");
		}
	}catch(Exception e){
		e.printStackTrace();
		if (e instanceof NoConnectionException){
			mb.setDBVerbindungKaputt();
		}else if(e instanceof SQLException){
			mb.setAllgemeinerDBFehler();
		}else{
			mb.setAnyError();
		}
		response.sendRedirect("./LoginView.jsp");
	}
}else if(zurReg.equals("zurReg")){
	mb.setRegWelcome();
	response.sendRedirect("./RegAppl.jsp?comeFrom=LoginAppl");	
}else if(comeFrom.contains("Appl")){
	//keine Message mehr erforderlich
	response.sendRedirect("./LoginView.jsp");
}else {
	mb.setGeneralWelcome();
	response.sendRedirect("./LoginView.jsp");	
}


%>
</body>
</html>