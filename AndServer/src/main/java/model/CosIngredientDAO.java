package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CosIngredientDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	CosIngredientDTO cosdto;
	ArrayList<CosIngredientDTO> addInfo_list;
	
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
	
	public CosIngredientDTO cos_detail(String cos_id) {
		
		conn();
		
		System.out.println("아이디 : "+cos_id);
			
		try {
			
			String sql = "select c.cos_name, c.cos_brand, c.cos_type, i.igt1, i.igt2, i.igt3, i.igt4, i.igt5 from cosmetic c, ingredient i where c.cos_id = i.cos_id and c.cos_id = ?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cos_id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				String cos_name = rs.getString(1);
				String cos_brand = rs.getString(2);
				String cos_type = rs.getString(3);
				String igt1 = rs.getString(4);
				String igt2 = rs.getString(5);
				String igt3 = rs.getString(6);
				String igt4 = rs.getString(7);
				String igt5 = rs.getString(8);
				
				cosdto = new CosIngredientDTO(cos_name, cos_brand, cos_type, igt1, igt2, igt3, igt4, igt5);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cosdto;	
		
	}
	
	
	//cos_add에 필요한 값 출력 메소드
	public ArrayList<CosIngredientDTO> cos_QR (String id) {
		
		addInfo_list = new ArrayList<CosIngredientDTO>();
		
		conn();
		String sql = "select cos_id, u_cos_id, amount from u_cosmetic where id = ? and state = '사용중'";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String cos_id = rs.getString(1);
				String u_cos_id = rs.getString(2);
				String amount = rs.getString(3);
				
				cosdto = new CosIngredientDTO(cos_id, u_cos_id, amount);
				
				addInfo_list.add(cosdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return addInfo_list;
	} 
	
	
}
