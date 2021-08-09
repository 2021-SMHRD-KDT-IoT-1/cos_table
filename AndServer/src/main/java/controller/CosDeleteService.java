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
import model.CosDeleteDAO;
import model.CosDeleteDTO;


@WebServlet("/CosDeleteService")
public class CosDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u_cos_id=request.getParameter("u_cos_id");
		String state=request.getParameter("state");
		
		int cnt = 0;
		
		System.out.println("ucosid : " + u_cos_id);

		CosDeleteDAO dao = new CosDeleteDAO();
		
		if(state.equals("완료")) {
			
			cnt = dao.cos_complete(u_cos_id);			
		
		}else if(state.equals("중단")) {
			
			cnt = dao.cos_stop(u_cos_id);			
			
		}
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
