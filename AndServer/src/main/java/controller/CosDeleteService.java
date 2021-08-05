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
		String state = request.getParameter("state");
	
		System.out.println("ucosid : " + u_cos_id);
		System.out.println("state : " + state);

		CosDeleteDTO cosdelete=new CosDeleteDTO(u_cos_id, state);
		CosDeleteDAO dao = new CosDeleteDAO();
		
		int cnt = dao.cos_delete(cosdelete);
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
