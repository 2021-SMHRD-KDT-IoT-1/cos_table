package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.MemberDTO;


@WebServlet("/ListViewService")
public class ListViewService extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/plan; charset=euc-kr");
		response.setContentType("application/json; charset=euc-kr");
		response.setCharacterEncoding("euc-kr");
		PrintWriter out=response.getWriter();
		
		ArrayList<MemberDTO> members =new ArrayList<MemberDTO>();
		members.add(new MemberDTO("ȭ��ǰ �̸�1","���Ⱓ1","����1"));
		members.add(new MemberDTO("ȭ��ǰ �̸�2","���Ⱓ2","����2"));
		members.add(new MemberDTO("ȭ��ǰ �̸�3","���Ⱓ3","����3"));
		members.add(new MemberDTO("ȭ��ǰ �̸�4","���Ⱓ4","����4"));
		members.add(new MemberDTO("ȭ��ǰ �̸�5","���Ⱓ5","����5"));
		
		Gson gson=new Gson();
		
		//Java��ü --> Json ���ڿ� ��ȯ
		String jsonArray =gson.toJson(members);
		System.out.println(jsonArray);
	
		
		MemberDTO member=new MemberDTO("ȭ��ǰ �̸�1","���Ⱓ1","����1");
		
		String jsonObj=gson.toJson(member);
		System.out.println(jsonObj);
		
		//��û �� ������ ������ ����
		out.print(jsonArray);
		//out.print(jsonObj);
	}

}
