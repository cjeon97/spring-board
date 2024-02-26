package repository;

import java.time.LocalDateTime;

public class Member {
	private Long no;
	private String memberid;
	private String memberpw;
	private String nick;
	private LocalDateTime regdate;
	
	public Member() {}
	
	public Member(String memberid, String memberpw, String nick, LocalDateTime regdate) {
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.nick = nick;
		this.regdate = regdate;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "Member [no=" + no + ", memberid=" + memberid + ", memberpw=" + memberpw + ", nick=" + nick
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
