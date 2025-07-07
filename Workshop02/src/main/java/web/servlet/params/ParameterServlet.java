package web.servlet.params;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/params"},loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //get방식 요청을 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>job: "+job+"</h3>");
		out.println("<h3>pageNo: "+pageNo+"</h3>");
		out.println("<h3>searchWorld: "+searchWord+"</h3>");
		out.println("</body></html>");
		
		out.close();
	}

	//post방식 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[ ] hobby = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		String hobbyString = "";
		for(String h : hobby){
			hobbyString += h+" ";
		}				
		PrintWriter out = response.getWriter();		
		out.println("<html><body>");
		out.println("<h3>name: "+name+"</h3>");
		out.println("<h3>email: "+email+"</h3>");
		out.println("<h3>gender: "+gender+"</h3>");
		out.println("<h3>hobby: "+hobbyString+"</h3>");
		out.println("<h3>favorite 제테크: "+favorite+"</h3>");
		out.println("<h3>기타: "+desc+"</h3>");
		
		out.println("</div></body></html>");
	}
}



