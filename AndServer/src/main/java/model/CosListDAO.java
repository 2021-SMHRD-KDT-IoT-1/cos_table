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

	public ArrayList<CosListDTO> cos_list(String id) {
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
	
	
	
	
	// 여정누나 삭제 기능에 필요한 u_cos_id, state 불러오기
		public ArrayList<CosListDTO> delete_info(String id) {
			ArrayList<CosListDTO> delete_info = new ArrayList<CosListDTO>();
	
			conn();
	
			try {
				String sql = "select u_cos_id, state from u_cosmetic where id = ? and state = '사용중'";
				
				psmt = conn.prepareStatement(sql);	
				
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
	
				if (rs.next()) {				
					String u_cos_id = rs.getString(1);
					String state = rs.getString(2);
	
					cosdto = new CosListDTO(u_cos_id, state);
	
					delete_info.add(cosdto);
	
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return delete_info;
		}
	
}
