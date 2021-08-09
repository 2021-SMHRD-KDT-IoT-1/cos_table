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

@WebServlet("/CosAddInfoService")
public class CosAddInfoService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		System.out.println("CosAddInfoService¿« ID : "+id);
		
		CosIngredientDAO cosdao = new CosIngredientDAO();
		
		ArrayList<CosIngredientDTO> cosdto = cosdao.cos_QR(id);
		
		Gson gson = new Gson();
		
		String jsonArray = gson.toJson(cosdto);
		
		out.print(jsonArray);
	
	}

}
