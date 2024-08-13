package com.ankit.servlet;

import java.io.IOException;
import com.ankit.dao.LoginDAO;
import com.ankit.user.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pword = req.getParameter("pword");
		UserBean ub=new UserBean();
		ub.setEmail(email);
		ub.setPassword(pword);
		UserBean user = new LoginDAO().login(ub);
		if (user !=null) {
			HttpSession session=req.getSession();
			session.setAttribute("userD", user);
			
			resp.sendRedirect("home.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("login-failed", "Invalid User and Password");
			resp.sendRedirect("login.jsp");
		}

	}

}
