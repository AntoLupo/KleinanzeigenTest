package de.hs_lu.bw4s.jdbc;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class NoConnectionException extends SQLException {
	
	public NoConnectionException(){
		super("Erzeugung der JDBC-Connection ist fehlgeschlagen");
	}
	public NoConnectionException(String msg){
		super(msg);
	}
	
}
