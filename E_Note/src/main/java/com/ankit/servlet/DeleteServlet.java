package com.ankit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ankit.dao.addnoteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/deleteNotes")
public class DeleteServlet extends HttpServlet {
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		addnoteDAO ad=new addnoteDAO();
		 boolean f= ad.deleteById(noteid);
		 HttpSession session=null;
		 if(f)
		 {
			 session=request.getSession();
			 session.setAttribute("updateMsg", "Notes Delete Successfully....");
			 response.sendRedirect("ShowNotes.jsp");
		 }
		 else {
			 session=request.getSession();
			 session.setAttribute("WrongMsg", "Somthing went wrong on server.....");
			 response.sendRedirect("ShowNotes.jsp");
		 }
		
	}

}
