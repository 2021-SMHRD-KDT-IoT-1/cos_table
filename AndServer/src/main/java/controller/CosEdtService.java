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

@WebServlet("/CosEdtService")
public class CosEdtService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String u_cos_id = request.getParameter("u_cos_id");
		
		String amount = request.getParameter("amount");
		
		System.out.println(u_cos_id +", "+amount);
		
		CosAddDAO dao = new CosAddDAO();
		
		CosAddDTO cosadd = new CosAddDTO(u_cos_id, amount);
		
		int cnt = dao.cos_edt(cosadd);
		
		if(cnt>0) {
			out.print(1);
		}else {
			out.print(0);
		}
		
	}

}
