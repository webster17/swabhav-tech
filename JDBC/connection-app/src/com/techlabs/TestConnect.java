package com.techlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.DatabaseMetaData;

public class TestConnect {
	public static void main(String args[]) {
		Connection con = null;
		try {
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/techlabs?"
							+ "user=root&password=");
			System.out.println(con.getClass());
			System.out.println("Connection done successfully!");
			System.out.println(con);
			System.out.println("Database Name: " + con.getCatalog());
			DatabaseMetaData dmd = (DatabaseMetaData) con.getMetaData();
			String url = dmd.getURL();
			System.out
					.println("Server Name: "
							+ url.substring(url.indexOf("/") + 2,
									url.lastIndexOf("/")));
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}