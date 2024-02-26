package myservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	
	Map<String, RequestHandler> handlerMap = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestHandler(req,resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestHandler(req,resp);
	}

	@Override
	public void init() throws ServletException {
		//서블릿이 인스턴스로 생성되면 호출되는 메소드(서블릿의 초기화를 용도로 사용하는 메소드)
		System.out.println("init()");
		handlerMap.put("/add", new AddHandler());
		handlerMap.put("/min", new MinHandler());
		handlerMap.put("/mul", new MulHandler());
		handlerMap.put("/div", new DivHandler());
		handlerMap.put("/", new IndexHandler());
	}
	
	protected void requestHandler(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 요청을 분석
		// 요청에 맞는 핸들러를 찾는다
		// handler동작
		// 결과 문자열과 결과 값이 담긴 req객체를 이용하여 jsp(뷰)로 포워딩
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
		}
		
		System.out.println("command: " + command);
		RequestHandler handler = handlerMap.get(command);
		String view = "";
		try {
			view = handler.handler(req, resp);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher(view).forward(req, resp);
		
	}
}
 