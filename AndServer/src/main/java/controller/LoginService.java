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
		System.out.println("��û�� ����");
		
		String id=request.getParameter("login_id");
		String pw=request.getParameter("login_pw");

		System.out.println(id);
		System.out.println(pw);

		if(id != null && pw!=null) {
			MemberDAO dao=new MemberDAO();
			MemberDTO login_member = dao.member_login(id, pw);
			
			System.out.println(login_member.getSkintype());
			
			PrintWriter out=response.getWriter();

			if(login_member != null) {//������� �ʴٸ�
				System.out.println("�α��� ����");
				out.print(login_member.getSkintype());//����
			}else {
				System.out.println("�α��� ����");
				out.print(0);
			}			
		}
		
	}
}
