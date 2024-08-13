package com.onlinestore;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session is Expierd.....<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		} else {
			ArrayList<AddProductBean> al = new ViewAllProductDAO().retrive();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("viewallproduct.jsp").forward(req, resp);
		}

	}
}
