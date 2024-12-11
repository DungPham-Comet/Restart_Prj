package application.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static application.constants.DatabaseConstants.*;

public class SiyoServices {
	public static ResultSet getAllSiyo() throws SQLException {
		String SELECT_QUERY = "SELECT * FROM iv_siyo";
		Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);	
		return ps.executeQuery();
	}
	
	public static ResultSet getSiyoByShohinCode(String shohinCode) throws SQLException {
		String SELECT_QUERY = "SELECT * FROM iv_siyo WHERE SHOHIN_CD = ?";
		Connection conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
		ps.setString(1, shohinCode);
		return ps.executeQuery();
	}
}
