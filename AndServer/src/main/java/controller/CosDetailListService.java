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
		
		//아이디 정상적으로 받아오는지 확인
		System.out.println("cos_detail_list의 cos_id : "+cos_id+" 들어옴");
		
		CosIngredientDAO cosdao = new CosIngredientDAO();
		
		CosIngredientDTO cosIng = cosdao.cos_detail(cos_id);
		
		String cos_name = cosIng.getCos_name();
		String cos_brand = cosIng.getCos_brand();
		String cos_type = cosIng.getCos_type();
		
		System.out.println(cos_name + " // " + cos_brand + " // " + cos_type);
		
		Gson gson = new Gson();
		
		String jsonArray = gson.toJson(cosIng);
		
		System.out.println("jsonArray //" + jsonArray);
		
		out.print(jsonArray);
	
	}

}
