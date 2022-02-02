package com.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection;
	
	//JDBC Connection URL : Containing information about host and port and database name
	public DBConnection(String dbUrl, String username, String password) throws ClassNotFoundException, SQLException {
		
		//Step 1: Register driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Step 2: Get connection object
		connection  = DriverManager.getConnection(dbUrl, username, password);
		
	} 
	
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() throws SQLException {
		if(this.connection!=null) {
			this.connection.close();
		}
	}
}