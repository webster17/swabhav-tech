package com.techlabs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String args[]) throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:8090;DatabaseName=aurionpro;integratedSecurity=true");
			System.out.println(con.getClass());
			System.out.println("Connection done successfully!");
			System.out.println(con);
			System.out.println("Database Name: " + con.getCatalog());
			DatabaseMetaData dmd = (DatabaseMetaData) con.getMetaData();
			String url = dmd.getURL();
			System.out
					.println("Server Name: "
							+ url.substring(url.indexOf("/") + 2,
									url.indexOf(";")));
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}