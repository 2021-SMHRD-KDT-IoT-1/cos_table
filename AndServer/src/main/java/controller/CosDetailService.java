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

import model.CosListDAO;
import model.CosListDTO;



@WebServlet("/CosDetailService")
public class CosDetailService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
		String cos_id = request.getParameter("cos_id");
		
		//���̵� ���������� �޾ƿ����� Ȯ��
		System.out.println(cos_id+"����");
		
		CosListDAO cosdao = new CosListDAO();
		
		ArrayList<CosListDTO> list = cosdao.cos_detail(cos_id);
		
		System.out.println(list.size());
		
		Gson gson = new Gson();
		
		
		String jsonArray = gson.toJson(list);
		
		System.out.println(jsonArray);
		
		out.print(jsonArray);
	
	}

}
