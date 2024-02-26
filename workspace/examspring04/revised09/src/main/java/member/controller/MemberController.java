package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.common.AlreadyMemberException;
import member.controller.validator.RegisterCommand;
import member.controller.validator.RegisterCommandValidator;
import member.service.MemberService;

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
			return "register/step1";
		}
		model.addAttribute("command", new RegisterCommand());
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String step2() {
		return "redirect:/register/step1"; //:뒤의 경로를 응답 리디렉트 경로로 사용
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String step3(@ModelAttribute("command")RegisterCommand cmd, Errors errors) { //Command Object 활용
		
		new RegisterCommandValidator().validate(cmd, errors); //검증 진행!

		if(errors.hasErrors()) { //error가 있다면(reject...)
			System.out.println("검증 에러 존재");
			return "register/step2";
		}
		
		try {
			memberService.regist(cmd);
			return "register/step3";
		}catch(AlreadyMemberException e) {
			//e.printStackTrace();
			errors.rejectValue("memberid", "duplicate");
			return "register/step2"; //회원가입 양식 다시 보여주기
		}
	}
	
	
}









