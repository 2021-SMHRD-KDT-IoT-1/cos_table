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


@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("join_id");
		String pw = request.getParameter("join_pw");
		String skintype = request.getParameter("join_skintype");
		
		System.out.println(id + " / " + pw + " / " + skintype);
		
		MemberDTO member = new MemberDTO(id, pw, skintype);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.member_join(member);
		
		PrintWriter out = response.getWriter();
		
		if(cnt > 0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
