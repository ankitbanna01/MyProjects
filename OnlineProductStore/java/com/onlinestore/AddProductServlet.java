package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session is expired......<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);

		} else {
			AddProductBean ab = new AddProductBean();
			ab.setpCode(req.getParameter("pcode"));
			ab.setpName(req.getParameter("pname"));
			ab.setpPrice(Double.parseDouble(req.getParameter("pprice")));
			ab.setpQty(Integer.parseInt(req.getParameter("pqty")));
			int k=new AddProductDAO().addProduct(ab);
			if(k>0) {
				req.setAttribute("msg", "Add product successfully.....<br>");
				req.getRequestDispatcher("addproduct.jsp").forward(req, resp);
			}
			
		}

	}

}
