package examspring03;

public class RegisterCommand {
	private String memberid;
	private String memberpw;
	private String memberpw2;
	private String nick;
	
	
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
	public String getMemberpw2() {
		return memberpw2;
	}
	public void setMemberpw2(String memberpw2) {
		this.memberpw2 = memberpw2;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
}
