package com.techlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTable {
	public static void main(String args[]) {
		Connection con = null;
		try {
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/techlabs?user=root&password=");
			System.out.println("Connection done successfully");

			String query = "SELECT * FROM DEPT";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("NO\tNAME\t\tLOCATION");
			while (rs.next()) {
				System.out.println(rs.getInt("DEPTNO") + "\t"
						+ rs.getString("DNAME") + "\t" + rs.getString("LOC"));
			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error Code: " + ex.getErrorCode());
		}
	}
}
