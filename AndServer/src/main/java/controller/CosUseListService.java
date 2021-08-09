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

@WebServlet("/CosUseListService")
public class CosUseListService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		//아이디 정상적으로 받아오는지 확인
		System.out.println(id+"들어옴 useList");
		
		CosListDAO cosdao = new CosListDAO();
		
		ArrayList<CosListDTO> list = cosdao.cos_history(id);
		
		System.out.println(list.size());
		
		Gson gson = new Gson();
		
		String jsonArray = gson.toJson(list);
		
		System.out.println(jsonArray);
		
		out.print(jsonArray);
	}

}
