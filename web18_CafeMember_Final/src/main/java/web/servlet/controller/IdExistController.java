package web.servlet.controller;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.MemberDAOImpl;

public class IdExistController implements Controller {

    // 로깅을 위한 Logger
    private static final Logger logger = Logger.getLogger(IdExistController.class.getName());

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id").trim();
        
        try {
            // MemberDAOImpl에서 idExist 메서드 호출하여 아이디 존재 여부 확인
            boolean flag = MemberDAOImpl.getInstance().idExist(id);

            // PrintWriter를 통해 flag 값 응답
            PrintWriter out = response.getWriter();
            out.print("{\"idExist\": " + flag + "}"); // JSON 형식으로 출력
            out.flush();
            
        } catch (Exception e) {
            // 예외가 발생하면 로그를 기록하고 에러 응답을 반환
            logger.log(Level.SEVERE, "Error checking if ID exists", e);

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Internal Server Error\"}");
        }

        return null; // ModelAndView 사용 안 함
    }
}
