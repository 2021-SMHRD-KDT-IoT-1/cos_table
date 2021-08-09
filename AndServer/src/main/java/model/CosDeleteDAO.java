package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CosDeleteDAO { //deletedao ->u_cos_id,state 완료/중단 ...  

	
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	CosDeleteDTO dto;

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
			if (rs != null) {
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

	public int cos_complete(String u_cos_id) {
			conn();
			String sql="update u_cosmetic set state = '완료' WHERE u_cos_id=?";
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, u_cos_id);
				
				cnt=psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return cnt;
		}
	
	public int cos_stop(String u_cos_id) {
		conn();
		String sql = "update u_cosmetic set state = '중단' where u_cos_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, u_cos_id);
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	
	public int update(CosDeleteDTO cosdelete) {
		conn();

		try {
			String sql = "update u_cosmetic set state='완료' where state=default";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cosdelete.getState());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}

}
