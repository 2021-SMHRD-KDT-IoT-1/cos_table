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


import model.CosAddDTO;
import model.CosDetailDAO;
import model.CosDetailDTO;


@WebServlet("/CosDetailService")
public class CosDetailService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 애플리케이션으로 전송 시 인코딩
				response.setContentType("application/json; charset=EUC-KR");
				
				PrintWriter out = response.getWriter();
				
				CosDetailDAO cosdao = new CosDetailDAO();
				CosDetailDTO cosdto = new CosDetailDTO();
				
				cosdto.setCos_id("cos_01");
				ArrayList<CosDetailDTO> cos = cosdao.cosDetail(cosdto);
				
//				for(int i=0; i<cos.size(); i++) {
//					System.out.println(cos.get(i).getCos_name());
//					System.out.println(cos.get(i).getCos_brand());
//					System.out.println(cos.get(i).getCos_type());
//				}
				
				Gson gson = new Gson();
				
				// Java 객체 --> JSON 문자열 변환
				String jsonArray = gson.toJson(cos);
				
//				System.out.println(jsonArray);
				
				//////////////////////////////////////////////////////////////////////////
				
				CosDetailDTO cosDetail = new CosDetailDTO("1025 독도 토너", "라운드랩", "스킨토너");
				
				String jsonObj = gson.toJson(cosDetail);
				System.out.println("들어옴!!");
				out.print(jsonObj);
	}

}
