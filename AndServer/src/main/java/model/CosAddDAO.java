package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CosAddDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	CosAddDTO cosdto;

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
	
	public ArrayList<CosAddDTO> cos_list(CosAddDTO cosadd) {
		ArrayList<CosAddDTO> list = new ArrayList<CosAddDTO>();
		
		conn();
		
		try {
			String sql = "select u_cos_id, u_cos_dead, state from u_cosmetic where u_cos_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cosadd.getU_cos_id());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String u_cos_id = rs.getString(1);
				String u_cos_dead = rs.getString(2);
				String state = rs.getString(3);
				
				System.out.println("값 확인이여;"+ u_cos_id.toString() + 
						u_cos_dead.toString() + state.toString());
				
				cosdto = new CosAddDTO(u_cos_id, u_cos_dead, state);
				
				list.add(cosadd);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
}
