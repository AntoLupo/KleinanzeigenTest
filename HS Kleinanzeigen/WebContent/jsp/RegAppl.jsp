<%@page import="de.hs_lu.bw4s.jdbc.NoConnectionException"%>
<%@page import="de.hs_lu.bw4s.beans.AccountBean"%>
<%@page import="de.hs_lu.bw4s.beans.MessageBean"%>
<%@page import="de.hs_lu.bw4s.beans.GUIBean"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ab" class="de.hs_lu.bw4s.beans.AccountBean" scope="session" />
<jsp:useBean id="mb" class="de.hs_lu.bw4s.beans.MessageBean" scope="session" />
<jsp:useBean id="gb" class="de.hs_lu.bw4s.beans.GUIBean" scope="session" />

<%! public String denullify(String s){ 
	if (s == null) return "";
	else return s;
} %>
<%
// Parameter aus http nach Java (JSP) einlesen
String userid   = request.getParameter("userid");
String username = request.getParameter("username");
String password = request.getParameter("password");
String email    = request.getParameter("email");
String comeFrom = this.denullify(request.getParameter("comeFrom"));
String register = this.denullify(request.getParameter("register"));
String zumlogin = this.denullify(request.getParameter("zumlogin"));
//if (comeFrom == null) comeFrom = "";
//if (register == null) register = "";
//if (zumlogin == null) zumlogin = "";

// Welche Aktion sollen wir durchführen (Aktionsweiche)?
if (register.equals("Registrieren")){
	out.println("Registrieren geklickt");
	ab.setUserid(userid);
	ab.setPassword(password);
	ab.setActive("Y");
	ab.setAdmin("N");
	ab.setUsername(username);
	ab.setEmail(email);
	try{
		boolean accountAngelegt = ab.insertAccountIfNotExists();
		if(accountAngelegt){//Account wurde angelegt
			mb.setRegSuccessful(userid);
		}else{//Account existiert schon
			mb.setAccountAlreadyExists(userid);
		}
	}catch(Exception e){//Unbekannter Fehler
		e.printStackTrace();
		if (e instanceof NoConnectionException){
			mb.setDBVerbindungKaputt();
		}else if(e instanceof SQLException){
			mb.setAllgemeinerDBFehler();
		}else{
			mb.setAnyError();
		}
	}
	response.sendRedirect("./RegView.jsp");
}else if (zumlogin.equals("zum Login")){
	out.println("'Zum Login' geklickt");
	//Weiterleiten auf eine Anmeldeseite
	mb.setGeneralWelcome();
	response.sendRedirect("./LoginAppl.jsp?comeFrom=RegAppl");
}else if(comeFrom.contains("Appl")){
	//keine Message mehr erforderlich
	response.sendRedirect("./RegView.jsp");
}else {
	out.println("kein sinnvoller Button geklickt");
	//Weiterleiten auf eine harmlose Seite, z.B. Anmeldeseite
	mb.setGeneralWelcome();
	response.sendRedirect("./LoginAppl.jsp?comeFrom=RegAppl");
}

System.out.println("userid: "   + userid);
System.out.println("username: " + username);
System.out.println("password: " + password);
System.out.println("email: "    + email);
System.out.println("register: " + register);
System.out.println("zumlogin: " + zumlogin);

%>
</body>
</html>