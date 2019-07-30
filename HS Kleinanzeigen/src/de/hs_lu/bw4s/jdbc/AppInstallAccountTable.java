package de.hs_lu.bw4s.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppInstallAccountTable {

	public Connection dbConn = null;
	
	public static void main(String[] args) throws NoConnectionException, SQLException{
		AppInstallAccountTable myApp = new AppInstallAccountTable();
		myApp.installAccountTable();
	}
	
	public void installAccountTable() throws SQLException{
		this.dbConn = new PostgreSQLAccess().getConnection(); 
		System.out.println("installAccountTable() gestartet");
		
		this.createAccountTable();
		
	}
	
	

	public void createAccountTable() throws SQLException{
		String sql = "create table account                (" +
				"userid   CHAR(16) NOT NULL PRIMARY KEY," +
				"password CHAR(32) NOT NULL            ," +
				"active   CHAR(1)  NOT NULL DEFAULT 'Y'," +
				"admin    CHAR(1)  NOT NULL DEFAULT 'N'," +
				"username VARCHAR(256)                 ," +
				"email    VARCHAR(256)                 )";
		System.out.println(sql);
		Statement myStat = dbConn.createStatement();
		myStat.executeUpdate(sql);
		System.out.println("Tabelle account angelegt");
	}



	

	
	}

