package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
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

	public int member_join(MemberDTO member) {
		conn();
		String sql="insert into member values(?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,member.getId());
			psmt.setString(2,member.getPw());
			psmt.setString(3,member.getSkintype());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {//오류가 캐치문에서 잡혔더라도 무조건적으로 실행 될 수 있는 구문 
			//오류가 나던 나지않던 sql은 종료되어야함
			
			close();
		}
		return cnt;
	}

	public MemberDTO member_login(String id, String pw) {
	
		conn();
		
		String sql="select * from member where id=? and pw=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {//1.column의 index ->1로 접근  or 2. column의 name->"skintype"
				String login_id = rs.getString(1);
				String login_pw = rs.getString(2);
				String skintype = rs.getString(3);

				dto = new MemberDTO(login_id, login_pw, skintype);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		return dto;
	}
}
