package examspring02;

import java.time.LocalDateTime;

public class Member {
	private Long number;
	private String memberid;
	private String memberpw;
	private String nick;
	private LocalDateTime regdate;
	
	
	public Member(String memberid, String memberpw, String nick, LocalDateTime regdate) {
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.nick = nick;
		this.regdate = regdate;
	}
	
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
	
}
