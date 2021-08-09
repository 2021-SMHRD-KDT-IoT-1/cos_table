package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CosListDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	CosListDTO cosdto;
	ArrayList<CosListDTO> arr_list;
	
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
	//----------------------------------------------------------------------
	// 사용중 화장품 리스트 출력 메소드

	public ArrayList<CosListDTO> cos_list(String id) {
		
		arr_list = new ArrayList<CosListDTO>();
		
		conn();
		
		try {
			String sql = "select u.u_cos_id, u.cos_id, u.u_cos_dead, c.cos_name from u_cosmetic u, cosmetic c where u.cos_id = c.cos_id and u.id = ? and u.state = '사용중'";
			
			psmt = conn.prepareStatement(sql);	
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String u_cos_id = rs.getString(1);
				String cos_id = rs.getString(2);
				String u_cos_dead = rs.getString(3);
				String cos_name = rs.getString(4);
				
				cosdto = new CosListDTO(u_cos_id, cos_id, u_cos_dead, cos_name);
				
				arr_list.add(cosdto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return arr_list;
	}

	//----------------------------------------------------------------------
	// 사용했던 화장춤 리스트 출력
	public ArrayList<CosListDTO> cos_history(String id) {
		ArrayList<CosListDTO> list = new ArrayList<CosListDTO>();

		conn();

		try {
			String sql = "select c.cos_name, u.u_cos_date, u.state from u_cosmetic u, cosmetic c where u.cos_id = c.cos_id and u.id = ? and u.state != '사용중'";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String cos_name = rs.getString(1);
				String u_cos_date = rs.getString(2);
				String state = rs.getString(3);

				cosdto = new CosListDTO(cos_name, u_cos_date, state);

				list.add(cosdto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
}
