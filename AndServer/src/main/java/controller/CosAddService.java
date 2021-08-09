package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CosAddDAO;
import model.CosAddDTO;


@WebServlet("/CosAddService")
public class CosAddService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String cos_id = request.getParameter("cos_id");
		String amount = request.getParameter("amount");
		
		CosAddDTO cosadd=new CosAddDTO(id, cos_id, amount);
		
		System.out.println("id : " + id);
		System.out.println("cosid : " + cos_id);
		System.out.println("amount : " + amount);
		
		CosAddDAO dao = new CosAddDAO();
		
		int cnt = dao.cos_add(cosadd);
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
