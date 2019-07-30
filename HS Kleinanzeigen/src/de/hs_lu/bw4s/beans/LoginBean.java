package de.hs_lu.bw4s.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hs_lu.bw4s.jdbc.PostgreSQLAccess;

public class LoginBean {
	String userid;
	String password;
	boolean isLoggedIn;
		
	public LoginBean(){
		super();
		this.userid   = "";
		this.password = "";
		this.isLoggedIn = false;
	}
	public String getLoginCheckRedirectHtml(){
		if (!this.isLoggedIn())
			return "<meta http-equiv='refresh' content='0; URL=./PortalAppl.jsp' >";
		else return "";
	}
//	public boolean checkUseridPasswort() throws SQLException{
//		return this.checkUseridPasswortInsecure();
//	}
//	public boolean checkUseridPasswortInsecure() throws SQLException{
//		/** true = Account mit this.userid und this.password existiert schon in der Account-Tabelle der DB
//		 * false = So ein Account existiert noch nicht 
//		 * Exception = anything else */
//		String sql = "SELECT userid from account where "
//				+ "userid = '" + this.userid + "' and "
//				+ "password = '" + this.password + "'";
//		System.out.println(sql);
//		java.sql.Statement prep = new PostgreSQLAccess().getConnection().createStatement();
//		ResultSet dbRes = prep.executeQuery(sql);
//		boolean accountGefunden = dbRes.next();
//		return accountGefunden;
//	}
	public boolean checkUseridPasswort() throws SQLException{
		/** true = Account mit this.userid und this.password existiert schon in der Account-Tabelle der DB
		 * false = So ein Account existiert noch nicht 
		 * Exception = anything else */
		String sql = "SELECT userid from account where userid = ? and password = ?";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1, this.userid);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		boolean accountGefunden = dbRes.next();
		return accountGefunden;
	}
	public String toString(){
		String s = "LoginBean mit ";
				s+= "userid: "   + this.getUserid() + ", ";
				s+= "password: " + this.getPassword() + ", ";
		return s;
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
