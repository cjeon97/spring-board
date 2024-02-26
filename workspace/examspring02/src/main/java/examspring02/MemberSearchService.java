package examspring02;

public class MemberSearchService {
	private MemberDao memberDao;
	private MemberPrintService memberPrintService;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberPrintService(MemberPrintService memberPrintService) {
		this.memberPrintService = memberPrintService;
	}
	
	public Member search(String memberid) {
		Member member = memberDao.selectOne(memberid);
		
		if(member == null) {
			throw new NoSuchMemberIdException();
		}
		memberPrintService.memberPrint(member);
		return member;
	}
}
