package com.onlinestore;
import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delet")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session is Expired....");
		}
		else {
			String pCode=req.getParameter("delet");
			int k=new DeletDAO().delete(pCode);
			if(k>=0)
			{
				req.setAttribute("msg", "Product delete Successfully.....");
				req.getRequestDispatcher("delete.jsp").forward(req, resp);
			}
			
		}
	}

}
