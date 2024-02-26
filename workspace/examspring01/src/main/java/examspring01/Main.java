package examspring01;

public class Main {
	public static void main(String[] args) {
		
		Assembler assembler = new Assembler();
		
		RegisterCommand param = new RegisterCommand();
		param.setMemberid("tester");
		param.setMemberpw("1234");
		param.setMemberpw2("1234");
		param.setNick("ttt");
		
		MemberRegisterService mrs = assembler.getMemberRegisterService();
		mrs.regist(param);
		System.out.println("회원가입 완료");
		
		EditPasswordService eps = assembler.getEditPasswordService();
		eps.editPassword(param.getMemberid(), "1234", "4321");
		System.out.println("비밀번호 변경 완료");

		
		
	}
}
