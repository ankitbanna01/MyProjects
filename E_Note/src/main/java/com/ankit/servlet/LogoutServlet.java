package com.ankit.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
        	 HttpSession session=req.getSession();
        	 session.getAttribute("userD");
        	 session.removeAttribute("userD");
        	 
        	 HttpSession session2=req.getSession();
        	 session2.setAttribute("logoutMsg","Logout Sucessfully...");
        	 resp.sendRedirect("login.jsp");
        	 
        	 
         }catch (Exception e) {
			// TODO: handle exception
		}
	}
}
