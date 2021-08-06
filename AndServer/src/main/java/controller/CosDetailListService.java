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

import model.CosIngredientDAO;
import model.CosIngredientDTO;


@WebServlet("/CosDetailListService")
public class CosDetailListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
		String cos_id = request.getParameter("cos_id");
		
		//���̵� ���������� �޾ƿ����� Ȯ��
		System.out.println(cos_id+"���� cos_detail_list");
		
		CosIngredientDAO cosdao = new CosIngredientDAO();
		
		CosIngredientDTO coslist = cosdao.cos_detail(cos_id);
		
		Gson gson = new Gson();
		
		String jsonArray = gson.toJson(coslist);
		
		System.out.println("jsonArray //" + jsonArray);
		
		out.print(jsonArray);
	
	}

}
