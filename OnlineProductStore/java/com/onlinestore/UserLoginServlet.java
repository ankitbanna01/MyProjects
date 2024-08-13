package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		UserBean ub=new UserLoginDAO().retrive(uName, pWord);
		if(ub==null)
		{
			req.setAttribute("msg", "Invalid User Password..<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("ubean", ub);
			req.getRequestDispatcher("userlogin.jsp").forward(req, resp);
		}
		
		
	}

}
