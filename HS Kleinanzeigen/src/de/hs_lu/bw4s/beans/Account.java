package de.hs_lu.bw4s.beans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hs_lu.bw4s.jdbc.PostgreSQLAccess;

public class Account {
	String userid;
	String password;
	String active;
	String admin;
	String username;
	String email;
	
	public Account(String userid, String password, String active,
					String admin, String username, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.active = active;
		this.admin = admin;
		this.username = username;
		this.email = email;
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
