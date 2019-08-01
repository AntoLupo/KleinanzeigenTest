package de.hs_lu.bw4s.beans;

import java.sql.SQLException;

public class AppTestAccountBean {

	AccountBean myAccountBean;
	
	public static void main(String[] args) throws SQLException {
		AppTestAccountBean myApp = new AppTestAccountBean();
		myApp.myAccountBean = new AccountBean();
		myApp.doSomething();
	}

	public void doSomething() throws SQLException{
		this.testInsertNoCheck();
		
		
	}
	public void testInsertNoCheck() throws SQLException{
		myAccountBean.setUserid("testus111");
		myAccountBean.setPassword("geheim");
		myAccountBean.setActive("Y");
		myAccountBean.setAdmin("N");
		myAccountBean.setUsername("Herbert");
		myAccountBean.setEmail("keine");
		myAccountBean.insertAccountNoCheck();
	}
}
