package examspring04;

public class MemberPrintService {
	private String type ="";
	
	public void setType(String type) {
		this.type=type;
	}
	
	public void memberPrint(Member member) {
		System.out.printf(type+":[%d, %s, %s, %tF]\n",
				member.getNumber(),
				member.getMemberid(),
				member.getNick(),
				member.getRegdate());
	}
}
