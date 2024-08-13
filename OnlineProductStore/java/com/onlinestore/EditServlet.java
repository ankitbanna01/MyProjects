package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session is Epired....<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
		}
		
	}

}
