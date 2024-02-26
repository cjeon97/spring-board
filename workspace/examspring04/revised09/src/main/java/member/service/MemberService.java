package member.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import member.common.AuthInfo;
import member.controller.validator.RegisterCommand;
import member.repository.Member;

public interface MemberService {
	public void regist(RegisterCommand cmd);
	
	public void editPassword(String memberid, String currpwd, String newpwd);
	
	public Member detail(String memberid);
	
	public Member detail(Long id);
	
	public AuthInfo login(String memberid, String memberpw);
	
	public List<Member> list(HashMap<String, LocalDateTime> param);
	
	public void out(String memberid, String memberpw);
}
