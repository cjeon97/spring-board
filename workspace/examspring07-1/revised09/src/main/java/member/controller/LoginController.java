package member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.common.AuthInfo;
import member.controller.validator.LoginCommand;
import member.controller.validator.LoginCommandValidator;
import member.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command")LoginCommand command, 
			@CookieValue(value="REMEMBER", required = false)Cookie cookie) {
		if(cookie != null) {
			command.setMemberid(cookie.getValue());
			command.setRememberId(true);
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
			AuthInfo authInfo = 
					memberService.login(command.getMemberid(), command.getMemberpw());
			session.setAttribute("authInfo", authInfo); //세션에 인증 정보 저장
			
			Cookie remember = new Cookie("REMEMBER", command.getMemberid());
			remember.setPath("/");
			if(command.isRememberId()) {
				remember.setMaxAge(60*60*24*30);
			}else {
				remember.setMaxAge(0);
			}
			response.addCookie(remember);
			
			return "login/loginSuccess";
		}catch(Exception e) {
			errors.reject("authFailed"); //글로벌 에러코드(커맨드객체 자체에 에러코드를 등록하는 개념)
			return "login/loginForm";
		}
	}
}








