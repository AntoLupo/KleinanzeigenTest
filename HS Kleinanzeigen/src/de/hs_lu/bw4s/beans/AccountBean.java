package de.hs_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hs_lu.bw4s.jdbc.PostgreSQLAccess;

public class AccountBean {
	String userid;
	String password;
	String active;
	String admin;
	String username;
	String email;
		
	public AccountBean(){
		super();
		this.userid   = "";
		this.password = "";
		this.active   = "Y";
		this.admin    = "N";
		this.username = "";
		this.email    = "";
	}
	public boolean checkAccountExists3() throws SQLException{
		/** true = Account    this.userid    existiert schon in der Account-Tabelle der DB
		 * false = Account existiert noch nicht 
		 * Exception = anything else */
		String sql = "SELECT userid from account";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		boolean accountGefunden = false;
		while (!accountGefunden && dbRes.next()){
			String aktuUserid = dbRes.getString("userid").trim();
			System.out.println("aktuUserid:\"" + aktuUserid + "\"");
			if (aktuUserid.equals(this.userid)){
				accountGefunden = true;
			}
		}
		return accountGefunden;
	}
	public boolean checkAccountExists2() throws SQLException{
		/** true = Account    this.userid    existiert schon in der Account-Tabelle der DB
		 * false = Account existiert noch nicht 
		 * Exception = anything else */
		String sql = "SELECT count(*) from account where userid = ?";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1, this.userid);
		ResultSet dbRes = prep.executeQuery();
		dbRes.next(); //muss immer true sein
		int anzahlGefunden = dbRes.getInt(1);
		if (anzahlGefunden == 0) return false;
		else return true;
//		return (anzahlGefunden > 0);
	}
	public boolean checkAccountExists1() throws SQLException{
		/** true = Account    this.userid    existiert schon in der Account-Tabelle der DB
		 * false = Account existiert noch nicht 
		 * Exception = anything else */
		String sql = "SELECT userid from account where userid = ?";
		System.out.println(sql);
		PreparedStatement prep = new PostgreSQLAccess().getConnection().prepareStatement(sql);
		prep.setString(1, this.userid);
		ResultSet dbRes = prep.executeQuery();
		boolean accountGefunden = dbRes.next();
		return accountGefunden;
	}

	public boolean checkAccountExists() throws SQLException{
		return this.checkAccountExists1();
	}
	public boolean insertAccountIfNotExists() throws SQLException{
		/** true = insert erfolgreich, this.userid hat noch nicht existiert
		 * false = insert abgelehnt, weil this.userid schon existiert
		 * Exception = anything else */
		this.prepareAttributesForDB();
		boolean accountNochFrei = !this.checkAccountExists();
		System.out.println("Account noch frei: " + accountNochFrei);
		if (accountNochFrei) this.insertAccountNoCheck();
		return accountNochFrei;
//		if (!this.checkAccountExists()){
//			this.insertAccountNoCheck();
//			return true;
//		} else return false;
	}
	
	public void prepareAttributesForDB(){
		if (userid.length() > 16) userid = userid.substring(0,16);
		if (password.length() > 32) password = password.substring(0,32);
		if (username.length() > 256) username = username.substring(0,256);
		if (email.length() > 256) email = email.substring(0,256);
		if (active.equalsIgnoreCase("Y")
				|| active.equalsIgnoreCase("YES")
				|| active.equalsIgnoreCase("J")
				|| active.equalsIgnoreCase("JA")) active = "Y";
		else active = "N";
		if (admin.equalsIgnoreCase("Y")
				|| admin.equalsIgnoreCase("YES")
				|| admin.equalsIgnoreCase("J")
				|| admin.equalsIgnoreCase("JA")) admin = "Y";
		else admin = "N";
	}
	
	public void insertAccountNoCheck() throws SQLException{
		//könnte auch insertSelfIntoDB heißen
		String sql = "insert into account (userid, password, active, admin, username, email) "
				+ "values (?,?,?,?,?,?)";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.userid);
		prep.setString(2, this.password);
		prep.setString(3, this.active);
		prep.setString(4, this.admin);
		prep.setString(5, this.username);
		prep.setString(6, this.email);
		prep.executeUpdate();
		System.out.println("Account " + this.userid + " erfolgreich eingefuegt");
	}
	
	public String toString(){
		String s = "AccountBean mit ";
				s+= "userid: "   + this.getUserid() + ", ";
				s+= "password: " + this.getPassword() + ", ";
				s+= "active: "   + this.getActive() + ", ";
				s+= "admin: "    + this.getAdmin() + ", ";
				s+= "username: " + this.getUsername() + ", ";
				s+= "email: "    + this.getEmail();				
		return s;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
