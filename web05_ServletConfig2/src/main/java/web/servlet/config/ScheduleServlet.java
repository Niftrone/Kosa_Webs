package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Schedule")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성..
		String today=request.getParameter("today");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("Today is "+today+"<br>");
		out.println("Football Games...");
		out.println("</h3></body></html>");
	}

}






