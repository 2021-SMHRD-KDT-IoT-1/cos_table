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

import model.CosAddDAO;
import model.CosAddDTO;

@WebServlet("/CosListService")
public class CosListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 애플리케이션으로 전송 시 인코딩
		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
//		String u_cos_id = request.getParameter("u_cos_id");
//		String u_cos_date = request.getParameter("u_cos_date");
//		String result = request.getParameter("result");
		
		
		CosAddDAO cosdao = new CosAddDAO();
		CosAddDTO cosdto = new CosAddDTO();
		
		cosdto.setU_cos_id("cos_01");
//		new ArrayList<CosAddDTO>();
		ArrayList<CosAddDTO> cos = cosdao.cos_list(cosdto);
		
		System.out.println(cos);
		
//		for(int i = 0; i < cos.size(); i++) {
//			System.out.println(cos.get(i));
//			
//		}
//		
//		cos.add(new CosAddDTO("cos_01", "22/08/02", "사용중"));
//		cos.add(new CosAddDTO("cos_02", "21/06/20", "사용중단"));
//		cos.add(new CosAddDTO("cos_03", "22/10/15", "사용중"));
		
		Gson gson = new Gson();
		
		// Java 객체 --> JSON 문자열 변환
		String jsonArray = gson.toJson(cos);
		
//		System.out.println(jsonArray);
		
		//////////////////////////////////////////////////////////////////////////
		
		CosAddDTO cos_list = new CosAddDTO("cos_01", "22/08/02", "사용중");
		
		String jsonObj = gson.toJson(cos_list);
		
//		System.out.println(jsonObj);
		
		//////////////////////////////////////////////////////////////////////////		
		
		//요청한 곳으로 데이터 전송
//		out.print(jsonArray);
//		out.print(jsonObj);
				
	}

}
