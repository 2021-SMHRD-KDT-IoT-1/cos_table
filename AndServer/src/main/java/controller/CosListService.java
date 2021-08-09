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
import model.CosListDAO;
import model.CosListDTO;

@WebServlet("/CosListService")
public class CosListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		//���̵� ���������� �޾ƿ����� Ȯ��
		System.out.println("coslistservice : "+id+" ����");
		
		CosListDAO dao = new CosListDAO();
		
		ArrayList<CosListDTO> arr_list = dao.cos_list(id);
		
		// ������� ȭ��ǰ ���� Ȯ��
		System.out.println("������� ȭ��ǰ ���� : "+arr_list.size());
		
		Gson gson = new Gson();
		
		String jsonArray = gson.toJson(arr_list);
		
		System.out.println("������� ȭ��ǰ ����Ʈ : "+jsonArray);
		
		out.print(jsonArray);			
	}
}
