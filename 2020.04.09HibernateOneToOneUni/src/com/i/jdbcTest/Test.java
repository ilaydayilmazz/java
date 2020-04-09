package com.i.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";

		Connection myConn;
		try {
			myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successful");
		} catch (SQLException e) {
			System.out.println("baglanti basarisiz");
			System.out.println(e);
		}
		
		
	}

}
