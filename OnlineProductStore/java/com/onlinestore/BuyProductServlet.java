package com.onlinestore;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession hs=req.getSession(false);
    	if(hs==null)
    	{
    		req.setAttribute("msg", "Session is Expired.....");
    		req.getRequestDispatcher("msg.jsp").forward(req, resp);
    	}else
    	{
    		req.getRequestDispatcher("buyproduct.jsp").forward(req, resp);
    	}
    }
}
