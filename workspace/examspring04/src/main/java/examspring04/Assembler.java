package examspring04;

// 스프링의 IoC/DI를 이해하기 위한 샘플 클래스
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private EditPasswordService editPasswordService;
	
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);//DI
		editPasswordService = new EditPasswordService(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	
	public EditPasswordService getEditPasswordService() {
		return editPasswordService;
	}
	
}
