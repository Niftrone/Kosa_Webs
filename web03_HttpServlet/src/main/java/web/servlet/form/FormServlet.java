package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	//thread생성 ->service() -->doGet()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		   1. 폼값 받아온다
           2. 그 값을 그대로 화면에 출력
		 */
	
		

		//한글처리는 request, response 각각 따로 해줘야 한다.
		//서버에서 브라우저로 응답할때 한글처리
		response.setContentType("text/html;charset=utf-8");		
		
		//브라우저에서 서버로 보낼때 한글처리..HttpServletRequest body부분에 담긴 데이타 한글처리
		//post방식일때만 적용
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
	
		/*
		결과페이지의 역할은 Servlet 역할이아니다.
		Servlet 로직중심의 기술이고
		Tag중심의 기술 JSP에서 담당하도록 한다.
		
		PrintWriter out=response.getWriter();

		out.println("<html><body>");
		out.println("<h2>당신의 이름은 "+name+"</h2>");
		out.println("<h2>당신이 사는 곳은 "+addr+"</h2>");
		out.println("</body></html>");		
		*/
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}














































