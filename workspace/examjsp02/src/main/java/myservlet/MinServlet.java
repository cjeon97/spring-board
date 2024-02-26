package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.AddCalc;
import calc.MinCalc;

public class MinServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("MinServlet 초기화");
	}
	
	@Override
	public void destroy() {
		System.out.println("MinServlet 소멸");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minForm.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		int result = new MinCalc().clac(Integer.parseInt(n1), Integer.parseInt(n2));
		
		//결과 데이터를 포워딩할 req객체에 속성으로 추가
		req.setAttribute("result", result);
		req.setAttribute("n1", n1);
		req.setAttribute("n2", n2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minProc.jsp");
		dispatcher.forward(req, resp);
	}
}
