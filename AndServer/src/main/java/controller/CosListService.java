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

@WebServlet("/CosListService")
public class CosListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���ø����̼����� ���� �� ���ڵ�
				response.setContentType("application/json; charset=EUC-KR");
				
				PrintWriter out = response.getWriter();
				
				String u_cos_id = request.getParameter("u_cos_id");
				String u_cos_date = request.getParameter("u_cos_date");
				
				ArrayList<CosAddDTO> cos = new ArrayList<CosAddDTO>();
				
				
				cos.add(new CosAddDTO(u_cos_id, u_cos_date));
				
				Gson gson = new Gson();
				
				// Java ��ü --> JSON ���ڿ� ��ȯ
				String jsonArray = gson.toJson(cos);
				
				System.out.println(jsonArray);
				
				//////////////////////////////////////////////////////////////////////////
				
				CosAddDTO cos_list = new CosAddDTO(u_cos_id, u_cos_date);
				
				String jsonObj = gson.toJson(cos_list);
				
				System.out.println(jsonObj);
				
				//////////////////////////////////////////////////////////////////////////		
				
				//��û�� ������ ������ ����
				out.print(jsonArray);
				out.print(jsonObj);
		
	}

}
