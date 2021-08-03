package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CosDeskDAO;
import model.CosDeskDTO;


@WebServlet("/CosAddDeskService")
public class CosAddDeskService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String table_id = request.getParameter("table_id");
		
		CosDeskDTO cosDeskAdd = new CosDeskDTO(table_id);
		
		System.out.println(table_id);
		
		CosDeskDAO dao = new CosDeskDAO();
		
		int cnt = dao.cos_desk_add(cosDeskAdd);
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
	}
}
