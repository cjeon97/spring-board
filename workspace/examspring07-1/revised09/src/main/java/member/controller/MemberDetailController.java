package member.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.common.MemberExistException;
import member.repository.Member;
import member.service.MemberService;

@Controller
public class MemberDetailController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/member/detail/{no}", method=RequestMethod.GET)
	public String detail(@PathVariable("no")Long no, Model model) {
		Member member = memberService.detail(no);
		if(member == null) {
			throw new MemberExistException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	

	@ExceptionHandler(TypeMismatchException.class)
	public String handlePathVariableMatchException() {
		return "member/paramError";
	}
	
//	@ExceptionHandler(MemberExistException.class)
//	public String handleMemberExsistException() {
//		return "member/notFound";
//	}
	

}
