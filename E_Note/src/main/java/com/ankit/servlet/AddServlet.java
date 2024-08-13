package com.ankit.servlet;

import java.io.IOException;
import com.ankit.dao.addnoteDAO;
import com.ankit.user.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addNotes")
public class AddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		

		UserData ud = new UserData();
		ud.setTitle(title);
		ud.setContent(content);
		ud.setUid(id);

		addnoteDAO ad = new addnoteDAO();
		boolean f = ad.AddNotes(ud);

		if (f) {
			resp.sendRedirect("ShowNotes.jsp");
		} else {
                System.out.println("data not insert");
		}
	}
}
