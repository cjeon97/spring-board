package member.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import member.controller.validator.MemberListCommand;
import member.repository.Member;
import member.service.MemberService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberService memberService;
	
	public MemberListController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/list")
	public String list(
			@ModelAttribute("command")MemberListCommand cmd, 
			Model model) {
		if(cmd.getFrom() != null && cmd.getTo() != null) {
			HashMap<String, LocalDateTime> param = new HashMap<>();
			param.put("from", cmd.getFrom());
			param.put("to", cmd.getTo());
			List<Member> members = memberService.list(param);
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}

}
