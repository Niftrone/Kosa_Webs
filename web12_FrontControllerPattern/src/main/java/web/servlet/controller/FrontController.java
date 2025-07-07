package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/Front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직 작성
		String command = request.getParameter("command");
		String path = "index.html"; // home 이나 error page
		if(command.equals("find")) { // 회원 검색 요청이 들어왔다면
			path = find(request, response);
		} else if(command.equals("register")) { // 회원 등록 요청이 들어왔다면
			path = register(request, response);
		} else if(command.equals("login")) { // 로그인 요청이 들어왔다면
			path = login(request, response);
		} else if(command.equals("allMember")) { // 회원 등록 요청이 들어왔다면
			path = allMember(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			Member rvo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		}catch(SQLException e) {
			
		}
		return path;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		Member pvo =null;
		String path = "index.html";	
		
		if(name.equals("") || address.equals("")) {
			 pvo = new Member(id, password);
		}else {
			pvo = new Member(id, password, name, address);
		}			
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		}catch(SQLException e) {
			System.out.println(e);
		}
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받아서
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String path = "index.html";
		// 2. try ~ catch 안에서 DAO 리턴 받아서 비즈니스 로직 호출
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, password);
			// 3. Member VO 반환...(Member 가 null이 아닐 때만) Session에 바인딩 
			if (rvo != null) {
				HttpSession session = request.getSession();
				System.out.println("LoginServlet...JSESSION =>"+session.getId());
				session.setAttribute("vo", rvo);
				path = "login_result.jsp"; // 로그인 성공 페이지
			}
		} catch (SQLException e) {
			// 에러 페이지를 하나 만들어서
			// 메세지만 바꾼다 ... 로그인 과정 중에 로그인을 실패하였습니다
		}
		// 4. Navigation...login_result.jsp
		return path;
	}

	private String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.html";
		try {
			ArrayList<Member> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		}catch(SQLException e) {
			
		}
		return path;
	}
}