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
		members.add(new MemberDTO("화장품 이름1","사용기간1","상태1"));
		members.add(new MemberDTO("화장품 이름2","사용기간2","상태2"));
		members.add(new MemberDTO("화장품 이름3","사용기간3","상태3"));
		members.add(new MemberDTO("화장품 이름4","사용기간4","상태4"));
		members.add(new MemberDTO("화장품 이름5","사용기간5","상태5"));
		
		Gson gson=new Gson();
		
		//Java객체 --> Json 문자열 변환
		String jsonArray =gson.toJson(members);
		System.out.println(jsonArray);
	
		
		MemberDTO member=new MemberDTO("화장품 이름1","사용기간1","상태1");
		
		String jsonObj=gson.toJson(member);
		System.out.println(jsonObj);
		
		//요청 한 곳으로 데이터 전송
		out.print(jsonArray);
		//out.print(jsonObj);
	}

}
