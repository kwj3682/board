package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", 
				"hr", "hr"
		);
	}
	public static void close(PreparedStatement pstmt) {
		close(null, pstmt);
	}
	public static void close(Connection con, PreparedStatement pstmt) {
		try { 
			if (pstmt != null) pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try { 
			if (con != null) con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}








