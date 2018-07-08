package com.techlabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TestSQLInjectionSolution {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Connection con = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:8090;DatabaseName=aurionpro;integratedSecurity=true");
			System.out.println("Connection done successfully!\n");

			String query = "SELECT * FROM DEPT WHERE DEPTNO = ?";
			System.out.println("Which records detail you want to show:");
			id = br.readLine();

			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.out.println("No data");
			} else {
				while (rs.next()) {
					System.out.println("\nDept No: " + rs.getInt("DEPTNO")
							+ "\nName: " + rs.getString("DNAME")
							+ "\nLocation: " + rs.getString("LOC"));
				}
			}
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error Code: " + ex.getErrorCode());
		}
	}
}
