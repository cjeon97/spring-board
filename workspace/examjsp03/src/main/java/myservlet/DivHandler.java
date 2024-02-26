package myservlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.DivCalc;

public class DivHandler implements RequestHandler {

	@Override
	public String handler(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		if(req.getMethod().equals("GET")) {
			return "/WEB-INF/views/divForm.jsp";
		}
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		int result = new DivCalc().clac(Integer.parseInt(n1), Integer.parseInt(n2));
		
		//결과 데이터를 포워딩할 req객체에 속성으로 추가
		req.setAttribute("result", result);
		req.setAttribute("n1", n1);
		req.setAttribute("n2", n2);
		
		return "/WEB-INF/views/divProc.jsp";
	}
}
