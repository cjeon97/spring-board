package member.common;

public class AuthInfo {
	private Long no;
	private String memberid;
	private String nick;
	
	public AuthInfo(Long no, String memberid, String nick) {
		this.no = no;
		this.memberid = memberid;
		this.nick = nick;
	}
	
	public Long getNo() {
		return no;
	}
	public String getMemberid() {
		return memberid;
	}
	public String getNick() {
		return nick;
	}

}
