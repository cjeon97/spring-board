package examspring03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberSearchService {
	
	@Autowired
	private MemberDao memberDao;
	private MemberPrintService memberPrintService;
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired(required = false)
	@Qualifier("stderr")
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
