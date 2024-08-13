package com.onlinestore;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllProductServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session is Expierd.....<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		} else {
			ArrayList<AddProductBean> al = new ViewAllProductDAO().retrive();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("userViewProduct.jsp").forward(req, resp);
		}

	}
}
