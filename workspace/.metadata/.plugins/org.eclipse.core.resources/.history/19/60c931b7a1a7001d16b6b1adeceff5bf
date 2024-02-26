package examspring01;

public class EditPasswordService {
	private MemberDao memberDao;

	public EditPasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void editPassword(String memberid, String currpwd, String newpwd) {
		Member member = memberDao.selectOne(memberid);
		if(member == null) {
			throw new NoSuchMemberIdException();
		}
		
		if(!member.getMemberpw().equals(currpwd)) {
			throw new PasswordCheckException();
		}
		
		member.setMemberpw(newpwd);
		memberDao.update(member);
	}
	
}
