package myservlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestHandler {
	public String handler(HttpServletRequest req, HttpServletResponse resp) throws Throwable;
}
