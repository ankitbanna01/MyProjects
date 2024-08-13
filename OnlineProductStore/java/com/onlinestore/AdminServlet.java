package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String un=req.getParameter("uname");
		String pw=req.getParameter("pword");
		AdminBean ab=new AdminDAO().adminlogin(un, pw);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login Process......<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("adbean", ab);
			req.getRequestDispatcher("adminsuccess.jsp").forward(req, resp);
		}
		
	}
}
