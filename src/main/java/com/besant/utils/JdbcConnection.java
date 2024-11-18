package com.besant.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection con;
	public static void jdbc() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		//	Establishing connection with db
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		
	}
}
