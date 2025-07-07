package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password =request.getParameter("password");
		
		String path = "index.html";
		try {
			Member rvo=MemberDAOImpl.getInstance().login(id, password);
			if(rvo!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("vo", rvo);
				path ="login_result.jsp";
			}
		}catch(SQLException e) {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}









