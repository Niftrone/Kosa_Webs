package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Product> list = ProductDAOImpl.getInstance().getAllProduct();
			request.setAttribute("list", list);
		}catch(SQLException e) {
			
		}
		
		request.getRequestDispatcher("allView.jsp").forward(request, response);
	}
}










