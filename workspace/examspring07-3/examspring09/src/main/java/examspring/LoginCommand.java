package examspring;

public class LoginCommand {
	private String memberid;
	private String memberpw;
	private boolean rememberid;
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
	public boolean isRememberid() {
		return rememberid;
	}
	public void setRememberid(boolean rememberid) {
		this.rememberid = rememberid;
	}
	
	
}
