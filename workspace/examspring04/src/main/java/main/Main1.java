package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig;
import examspring04.MemberRegisterService;
import examspring04.MemberSearchService;
import examspring04.RegisterCommand;

public class Main1 {
	public static void main(String[] args) {
		
		//Assembler assembler = new Assembler();
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		
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
		
		
		MemberSearchService mss =
				ctx.getBean("memberSearchService", MemberSearchService.class);
		mss.search("tester2");
		System.out.println("멤버 찾기 완료");
		
		
		System.out.println("프로그램 정상적으로 종료");
	}
}
