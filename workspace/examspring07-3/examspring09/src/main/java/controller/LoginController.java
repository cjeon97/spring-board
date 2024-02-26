package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import examspring.AuthInfo;
import examspring.LoginCommand;
import service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;
	
	public LoginController(AuthService authService) {
		this.authService=authService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("command")LoginCommand command,
			@CookieValue(value="REMEMBER", required=false)Cookie cookie) {
		if(cookie != null) {
			command.setMemberid(cookie.getValue());
			command.setRememberid(true);
		}
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@ModelAttribute("command")LoginCommand command, 
			Errors errors,
			HttpSession session,
			HttpServletResponse response) {
		new LoginCommandValidator().validate(command, errors);
		
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			AuthInfo authInfo = authService.authenticate(command.getMemberid(), command.getMemberpw());
			session.setAttribute("authInfo", authInfo); // 세션에 인증정보 저장
			
			Cookie remember = new Cookie("REMEMBER", command.getMemberid());
			remember.setPath("/");
			if(command.isRememberid()) {
				remember.setMaxAge(60*60*24);
			} else {
				remember.setMaxAge(0);
			}
			response.addCookie(remember);
			
			return "login/loginSuccess";
		} catch(Exception e) {
			errors.reject("authFailed"); //글로벌 에러코드(커맨드객체 자체에 에러코드를 등록하는 개념)
			return "login/loginForm";
		}
		
	}
}
