package examspring02;

public class MemberPrintService {
	public void memberPrint(Member member) {
		System.out.printf("[%d, %s, %s, %tF]\n",
				member.getNumber(),
				member.getMemberid(),
				member.getNick(),
				member.getRegdate());
	}
}
