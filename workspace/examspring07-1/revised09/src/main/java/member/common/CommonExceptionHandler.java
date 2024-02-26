package member.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "member")
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error/commonError";
	}
}
