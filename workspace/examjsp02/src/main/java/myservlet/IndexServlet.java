package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.AddCalc;

public class IndexServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("IndexServlet 초기화");
	}
	
	@Override
	public void destroy() {
		System.out.println("IndexServlet 소멸");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}

}
