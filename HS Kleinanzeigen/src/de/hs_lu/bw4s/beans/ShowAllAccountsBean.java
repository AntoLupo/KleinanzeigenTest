package de.hs_lu.bw4s.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import de.hs_lu.bw4s.jdbc.PostgreSQLAccess;

public class ShowAllAccountsBean {

	Vector<Account> allAccounts;
	
	public ShowAllAccountsBean() throws SQLException {
		this.allAccounts = new Vector<Account>();
		this.readAllAccountsFromDB();
	}
	
	public void readAllAccountsFromDB() throws SQLException{
		String sql = "Select userid, password, active, admin, username, email " +
						"from account";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		ResultSet dbRes = dbConn.createStatement().executeQuery(sql);
		while (dbRes.next()){
			Account newAccount = new Account(
						dbRes.getString("userid"),
						dbRes.getString("password"),
						dbRes.getString("active"),
						dbRes.getString("admin"),
						dbRes.getString("username"),
						dbRes.getString("email")
					);
			this.allAccounts.add(newAccount);
		}
	}
	public String getAccountsAsHtml(){
		String html = "";
		html += "<table>\n";
		
		html += "<tr>\n";
		html += "<th>userid</th>\n";
		html += "<th>password</th>\n";
		html += "<th>active</th>\n";
		html += "<th>admin</th>\n";
		html += "<th>username</th>\n";
		html += "<th>email</th>\n";
		html += "</tr>\n";
		
		for(Account myAccount : this.allAccounts){
			html += "<tr>\n";
			html += "<td>" + myAccount.getUserid()   + "</td>\n";
			html += "<td>" + myAccount.getPassword() + "</td>\n";
			html += "<td>" + myAccount.getActive()   + "</td>\n";
			html += "<td>" + myAccount.getAdmin()    + "</td>\n";
			html += "<td>" + myAccount.getUsername() + "</td>\n";
			html += "<td>" + myAccount.getEmail()    + "</td>\n";
			html += "</tr>\n";
		}
		html += "</table>\n";
		return html;
//		for(int index = 0; index <= this.allAccounts.size(); index++){
//		Account myAccount = this.allAccounts.get(index);
//		
//		}		
//		Iterator<Account> myIter = this.allAccounts.iterator();
//		while(myIter.hasNext()){
//		Account myAccount = myIter.next();
//		
//		}
	}

}