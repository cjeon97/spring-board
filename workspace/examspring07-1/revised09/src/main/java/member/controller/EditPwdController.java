package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.common.AuthInfo;
import member.common.PasswordCheckException;
import member.controller.validator.EditPwdCommand;
import member.controller.validator.EditPwdCommandValidator;
import member.service.MemberService;

@Controller
@RequestMapping("edit/changepwd")
public class EditPwdController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("command")EditPwdCommand cmd) {
		System.out.println("controller");
		return "edit/changepwdForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String edit(
			@ModelAttribute("command")EditPwdCommand cmd,
			Errors errors,
			HttpSession session) {
		new EditPwdCommandValidator().validate(cmd, errors);
		if(errors.hasErrors()) {
			return "edit/changepwdForm";
		}
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		try {
			memberService.editPassword(
				authInfo.getMemberid(),
				cmd.getCurpwd(),
				cmd.getNewpwd());
			return "edit/changepwd";
		}catch(PasswordCheckException e) {
			errors.rejectValue("curpwd", "notmatch");
			return "edit/changepwdForm";
		}
		
	}

}







