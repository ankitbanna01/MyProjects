package com.ankit.servlet;

import java.io.IOException;
import com.ankit.dao.RegisterDAO;
import com.ankit.user.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean rs = new UserBean();
		rs.setFull_Name(req.getParameter("uname"));
		rs.setEmail(req.getParameter("email"));
		rs.setPassword(req.getParameter("pword"));

		int k = new RegisterDAO().register(rs);
		HttpSession session;
		if (k == 1) {
			session = req.getSession();
			session.setAttribute("reg-sucess", "Registration Sucessfully..!");
			resp.sendRedirect("register.jsp");
		} else {
			session = req.getSession();
			session.setAttribute("failed-msg", "Somthing went wrong on server");
			resp.sendRedirect("register.jsp");
		}
	}

}
