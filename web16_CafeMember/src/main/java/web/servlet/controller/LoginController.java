package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password =request.getParameter("password");			
		String path = "index.jsp";
		try {
			Member rvo=MemberDAOImpl.getInstance().login(id, password);
			if(rvo!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("vo", rvo);
				path ="login_result.jsp";
			}
		}catch(SQLException e) {
			
		}			
		return new ModelAndView(path); //forward방식으로 페이지이동
	}

}
