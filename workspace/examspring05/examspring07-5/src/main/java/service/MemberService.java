package service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examspring.AlreadyMemberException;
import examspring.NoSuchMemberException;
import examspring.PasswordCheckException;
import examspring.RegisterCommand;
import repository.Member;
import repository.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public void regist(RegisterCommand cmd) {
		if(!cmd.getMemberpw().equals(cmd.getMemberpw2())) {
			throw new PasswordCheckException();
		}
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
	
	public void editPassword(String memberid, String currpwd, String newpwd1, String newpwd2) {
		if(!newpwd1.equals(newpwd2)) {
			throw new PasswordCheckException();
		}
		
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberException();
		}
		if(!currpwd.equals(member.getMemberpw())) {
			throw new PasswordCheckException();
		}
		
		member.setMemberpw(newpwd1);
		mapper.update(member);
		
	}
	
	public Member detail(String memberid) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberException();
		}
		
		return member;
	}
	
	public Member login(String memberid, String memberpw) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberException();
		}
		if(!member.getMemberpw().equals(memberpw)) {
			throw new PasswordCheckException();
		}
		
		return member;
	}
	
	public void out(String memberid, String memberpw) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberException();
		}if(!member.getMemberpw().equals(memberpw)) {
			throw new PasswordCheckException();
		}
		mapper.delete(new Member(memberid, memberpw, "", null));
	}
}
