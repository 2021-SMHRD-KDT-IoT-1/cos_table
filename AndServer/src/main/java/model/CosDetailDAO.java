package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CosDetailDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	CosDetailDTO dto = null;
	ArrayList<CosDetailDTO> li = null;

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
	
	public ArrayList<CosDetailDTO> cosDetail(CosDetailDTO dto) {
		li = new ArrayList<CosDetailDTO>();
		conn();
		
		String sql = "select * from cosmetic where cos_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getCos_id());
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				String cos_name=rs.getString(1);
				String cos_brand=rs.getString(2);
				String cos_type=rs.getString(3);
				
				dto= new CosDetailDTO(cos_name, cos_brand, cos_type);
				li.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return li;
	}
}
