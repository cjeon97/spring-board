package examspring02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//Assembler assembler = new Assembler();
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appContext.xml");
		
		
		RegisterCommand param = new RegisterCommand();
		param.setMemberid("tester1");
		param.setMemberpw("1234");
		param.setMemberpw2("1234");
		param.setNick("ttt");
		
		MemberRegisterService mrs = 
				ctx.getBean("memberRegisterService", MemberRegisterService.class);
		mrs.regist(param);
		System.out.println("회원가입 완료");
		
		param.setMemberid("tester2");
		param.setMemberpw("1234");
		param.setMemberpw2("1234");
		param.setNick("qqq");
		mrs.regist(param);
		System.out.println("회원가입 완료");
		
		EditPasswordService eps =
				ctx.getBean("editPasswordService", EditPasswordService.class);
		eps.editPassword(param.getMemberid(), "1234", "4321");
		System.out.println("비밀번호 변경 완료");
		
		MemberListPrintService mlps =
				ctx.getBean("memberListPrintService", MemberListPrintService.class);
		mlps.memberListPrint();
		System.out.println("전체 리스트 출력완료");
		
		MemberSearchService mss =
				ctx.getBean("memberSearchService", MemberSearchService.class);
		mss.search("tester2");
		System.out.println("멤버 찾기 완료");
		
		VersionInfoService vis =
				ctx.getBean("versionInfoService", VersionInfoService.class);
		vis.versionPrint();
		
		System.out.println("프로그램 정상적으로 종료");
	}
}
