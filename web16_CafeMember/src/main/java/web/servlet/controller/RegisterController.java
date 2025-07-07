package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		
		String path = "index.jsp";	
		
		Member pvo = new Member(id, password, name, address);
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);			
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView("allMemeber.do", true);//Redirect방식
	}

}







