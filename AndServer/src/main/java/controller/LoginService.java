package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 들어옴");
		
		String id=request.getParameter("login_id");
		String pw=request.getParameter("login_pw");

		System.out.println(id);
		System.out.println(pw);

		if(id != null && pw!=null) {
			MemberDAO dao=new MemberDAO();
			MemberDTO login_member = dao.member_login(id, pw);
			
			System.out.println(login_member.getSkintype());
			
			PrintWriter out=response.getWriter();

			if(login_member != null) {//비어있지 않다면
				System.out.println("로그인 성공");
				out.print(login_member.getSkintype());//성공
			}else {
				System.out.println("로그인 실패");
				out.print(0);
			}			
		}
		
	}
}
