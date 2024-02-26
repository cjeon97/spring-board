package examspring01;

import java.time.LocalDateTime;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterCommand cmd) {
		if(!cmd.getMemberpw().equals(cmd.getMemberpw2())) {
			throw new PasswordCheckException();
		}
		Member member = memberDao.selectOne(cmd.getMemberid());
		if(member != null) {
			throw new ExistingIdException();
		}
		
		Member registMember = new Member(
				cmd.getMemberid(),
				cmd.getMemberpw(),
				cmd.getNick(),
				LocalDateTime.now());
		memberDao.insert(registMember);
	}
	
	
}
