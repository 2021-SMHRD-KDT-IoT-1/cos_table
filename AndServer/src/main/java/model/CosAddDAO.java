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
	
	public int cos_add(CosAddDTO cosadd) {
		conn();
		String sql="insert into u_cosmetic values (?,?,?,sysdate,?, sysdate+(interval '1' year))";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, cosadd.getU_cos_id());
			psmt.setString(2, cosadd.getId());
			psmt.setString(3, cosadd.getCos_id());
			psmt.setString(4, cosadd.getAmount());
			cnt=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	public int cos_edt(CosAddDTO cosadd) {
		
		conn();
		try {
			String sql = "update u_cosmetic set amount=? where u_cos_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, cosadd.getAmount());
			psmt.setString(2, cosadd.getU_cos_id());
			cnt=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
