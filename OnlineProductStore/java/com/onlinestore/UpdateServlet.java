package com.onlinestore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "session is expired....<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		} else {
			ArrayList<AddProductBean> al = (ArrayList<AddProductBean>) hs.getAttribute("alist");
			String pCode = req.getParameter("pcode");
			Iterator<AddProductBean> it = al.iterator();
			while (it.hasNext()) {
				AddProductBean ab = (AddProductBean)it.next();
				if (pCode.equals(ab.getpCode())) {
					ab.setpPrice(Double.parseDouble(req.getParameter("pprice")));
					ab.setpQty(Integer.parseInt(req.getParameter("pqty")));

					int k = new UpdateDAO().insert(ab);
					if (k > 0) {
						req.setAttribute("msg", "Profile Update Succesful...");
						req.getRequestDispatcher("updateproduct.jsp").forward(req, resp);
					}
					break ;
				}
			}
		}
	}
}
