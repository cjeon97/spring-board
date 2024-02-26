package member.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.common.AlreadyMemberException;
import member.common.AuthInfo;
import member.common.MemberExistException;
import member.common.PasswordCheckException;
import member.controller.validator.RegisterCommand;
import member.repository.Member;
import member.repository.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;
	
	public void regist(RegisterCommand cmd) {
		Member member = mapper.selectOne(cmd.getMemberid());
		if(member != null) {
			throw new AlreadyMemberException();
		}
		Member registMember = new Member(
				cmd.getMemberid(),
				cmd.getMemberpw(),
				cmd.getNick(),
				LocalDateTime.now());
		
		mapper.insert(registMember);
	}
	
	public void editPassword(
			String memberid, String currpwd, String newpwd) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new MemberExistException();
		}
		if(!currpwd.equals(member.getMemberpw())) {
			throw new PasswordCheckException();
		}
		
		member.setMemberpw(newpwd);
		mapper.update(member);
		
	}
	
	public Member detail(String memberid) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new MemberExistException();
		}
		
		return member;
	}
	
	public Member detail(Long id) {
		Member member = mapper.selectByNo(id);
		if(member == null) {
			throw new MemberExistException();
		}
		
		return member;
	}
	
	public AuthInfo login(String memberid, String memberpw) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new MemberExistException();
		}
		if(!member.getMemberpw().equals(memberpw)) {
			throw new PasswordCheckException();
		}
		
		return new AuthInfo(member.getNo(), member.getMemberid(), member.getNick());
	}
	
	public List<Member> list(HashMap<String, LocalDateTime> param){
		List<Member> result = mapper.selectRegdate(param);
		result.stream().forEach(p -> p.setMemberpw("********"));
		return result;
	}
	
	public void out(String memberid, String memberpw) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new MemberExistException();
		}if(!member.getMemberpw().equals(memberpw)) {
			throw new PasswordCheckException();
		}
		mapper.delete(new Member(memberid, memberpw, "", null));
	}
}
