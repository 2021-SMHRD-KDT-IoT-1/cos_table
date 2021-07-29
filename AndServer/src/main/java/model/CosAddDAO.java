package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CosAddDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	MemberDTO dto;

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}	
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int cos_add() {
		conn();
		String sql="insert into u_cosmetic values (?,?,?,sysdate,?, sysdate+(interval '2' year) SYSDATE+(INTERVAL '1' YEAR))";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, "임시");
			psmt.setString(2, "임시");
			psmt.setString(3, "임시");
			psmt.setString(4, "임시");
			psmt.setString(5, "임시");
			psmt.setString(6, "임시");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return 0;
	}
}
