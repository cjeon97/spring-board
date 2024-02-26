package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import examspring.AuthInfo;
import examspring.EditPwdCommand;
import examspring.PasswordCheckException;
import service.MemberService;

@Controller
@RequestMapping("/edit/changepwd")
public class EditPwdController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("command")EditPwdCommand cmd) {
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
			memberService.editPassword(authInfo.getMemberid(), cmd.getCurpwd(), cmd.getNewpwd());
			return "edit/changepwd";
		} catch (PasswordCheckException pce) {
			errors.rejectValue("curpwd", "nomatch");
			return "edit/changepwdForm";
		}
	}
}
