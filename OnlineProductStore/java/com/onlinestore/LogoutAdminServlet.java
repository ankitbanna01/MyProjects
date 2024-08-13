package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutAdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session is expired....<br>");
		}
		else
		{
			hs.invalidate();
			req.setAttribute("msg", "LogoutSuccesFully.....<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}

}
