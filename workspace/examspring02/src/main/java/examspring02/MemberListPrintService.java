package examspring02;

import java.util.List;

public class MemberListPrintService {
	private MemberDao memberDao;
	private MemberPrintService memberPrintService;
	
	public MemberListPrintService(MemberDao memberDao, MemberPrintService memberPrintService) {
		this.memberDao = memberDao;
		this.memberPrintService = memberPrintService;
	}
	
	public void memberListPrint() {
		List<Member> memList = memberDao.selectAll();
		for(Member member : memList) {
			memberPrintService.memberPrint(member);
		}
	}
	
	
}
