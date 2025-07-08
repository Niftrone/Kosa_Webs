package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Count;
import com.algo.Kickboard;

@WebServlet("/front.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("count")) {
			wordCount(request, response);
		}else if (command.equals("kickboard")) {
			kickboardCount(request, response);
		}
	}
	
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("words");
		String result = new Count().execute(word);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	
	private void kickboardCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. fname 값 받아서.. input.txt 
		 * String path = 
		 * 		1) ContextPath/res
		 * 		2) 1)번의 경로를 path 할당
		 * 2. 1번의 값을 가지고 file 객체 생성
		 * 
		 * 	File f = new File(path, fname);
		 * 
		 * 3. new Kickoboard().execute(f);
		 * out.print(result)
		 * */
		String fname = request.getParameter("fname");
		String path = request.getServletContext().getRealPath("res");
		File f = new File(path, fname);
		
		try {
			int result = new Kickboard().execute(f);
			request.setAttribute("result", result);
			request.getRequestDispatcher("Result.jsp").forward(request, response);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
