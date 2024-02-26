package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import examspring.AlreadyMemberException;
import examspring.RegisterCommand;
import service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; 
	
	@RequestMapping("/register/step1")
	public String step1() {
		return "register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String step2(
			@RequestParam(value="agree", defaultValue="false") Boolean agree,
			Model model) {
		if(!agree) {
			return "redirect:/register/step1";
		}
		model.addAttribute("command", new RegisterCommand());
		return "register/step2";	
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String step2() {
		return "redirect:/register/step1";	
	}
	
	// 파라미터에 @ModelAttribute("cmd")를 추가하면 넘겨진 파라미터의 이름을 설정 후
	// 자동으로 넘기게된다. jsp파일에서 ${cmd}를 이용하여 받아올 수 있다.
	// 만약 정해진 이름이 없다면(어노테이션이 없다면) 클래스의 소문자이름을 이용해 받아야한다
	// ex) ${registerCommand.memberid}
	// 스프링에서 제공하는 <form:form>을 사용하기 위해서는 커맨드객체의 이름이 command가 되어야만 한다
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String step3(@ModelAttribute("command") RegisterCommand cmd, Errors errors) {
		new RegisterCommandValidator().validate(cmd, errors);
		if(errors.hasErrors()) {
			System.out.println("검증에 에러발생");
			return "register/step2";
		}
		
		try {
			memberService.regist(cmd);
			return "register/step3";
		} catch(AlreadyMemberException amb) {
			amb.printStackTrace();
			errors.rejectValue("memberid", "duplicate");
			return "register/step2";
		}

	}
	
}
