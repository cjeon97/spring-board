package controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import examspring.MemberListCommand;
import repository.Member;
import repository.mapper.MemberMapper;

@Controller
public class MemberListController {

	@Autowired
	private MemberMapper mapper;
	
	@RequestMapping("/member/list")
	public String list(
			@ModelAttribute("command")MemberListCommand cmd,
			Model model) {
		if(cmd.getFrom()!=null && cmd.getTo() != null) {
			HashMap<String, LocalDateTime> param = new HashMap<>();
			param.put("from", cmd.getFrom());
			param.put("to", cmd.getTo());
			List<Member> members = mapper.selectRegdate(param);
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
