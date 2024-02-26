package service;

import examspring.AuthInfo;
import examspring.NoSuchMemberException;
import examspring.PasswordCheckException;
import repository.Member;
import repository.mapper.MemberMapper;

public class AuthService {
	
	
	private MemberMapper mapper;
	
	public void setMemberMapper(MemberMapper mapper) {
		this.mapper=mapper;
	}
	
	public AuthInfo authenticate(String memberid, String memberpw) {
		Member member = mapper.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberException();
		}
		if(!member.getMemberpw().equals(memberpw)) {
			throw new PasswordCheckException();
		}
		
		return new AuthInfo(member.getNo(), member.getMemberid(), member.getNick());
	}
}
