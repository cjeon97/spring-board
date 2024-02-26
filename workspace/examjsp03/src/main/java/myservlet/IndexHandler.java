package myservlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexHandler implements RequestHandler {

	@Override
	public String handler(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		return "/WEB-INF/views/index.jsp";
	}

}
