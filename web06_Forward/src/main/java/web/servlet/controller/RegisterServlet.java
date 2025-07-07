package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;

@WebServlet(urlPatterns = {"/Register"}, loadOnStartup = 2)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		/*
		  1. 폼값 받아서
		  2. DAO반환받고
		  3. biz logic 호출...registerMember(값)
		  4. 바인딩?
		  5. 네비게이션
		 */
		String id   = request.getParameter("id");
		String pass   = request.getParameter("pass");
		String name   = request.getParameter("name");
		
	    Member pvo = new Member(id, pass, name);
	    
	    //request.setAttribute("vo", pvo);
	    //세션에 바인딩
	    /*
	    HttpSession session=request.getSession();
	    session.setAttribute("vo", pvo); //응답을 하더라도 계속 데이타를 저장(로그인)
	    */
	    
	    //ServletContext에 바인딩
	    getServletContext().setAttribute("vo", pvo);
	    
	    PrintWriter out=  response.getWriter();
	    out.println("<html><body><h3>");
	    out.println("Next Page Connection...");
	    out.println("<a href='list.jsp'>ListServlet Page</a></h3>");
	    out.println("</body></html>");
		
	}
}































