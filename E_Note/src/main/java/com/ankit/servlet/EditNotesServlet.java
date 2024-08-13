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
 * Servlet implementation class EditNotesServlet
 */
@SuppressWarnings("serial")
@WebServlet("/EditNotes")
public class EditNotesServlet extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			try {
				//Integer noteid=Integer.parseInt(request.getParameter("noteid"));
				int noteid=Integer.parseInt(request.getParameter("noteid"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				addnoteDAO ad=new addnoteDAO();
				boolean f= ad.editNotes(noteid, title, content);
				
				if(f)
				{
					System.out.println("Edit Your Notes");
					HttpSession session=request.getSession();
					session.setAttribute("updateMsg", "Notes Update Sucessfully");
					response.sendRedirect("ShowNotes.jsp");
				}else
				{
					System.out.println("data not insert in edit");
				}
				
			}catch (Exception e) {
                 e.printStackTrace();

			}

		

		

	}

}
