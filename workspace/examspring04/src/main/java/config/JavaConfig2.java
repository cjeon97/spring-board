package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import examspring04.MemberDao;
import examspring04.MemberPrintService;
import examspring04.MemberRegisterService;
import examspring04.MemberSearchService;

@Configuration
public class JavaConfig2 {

	@Bean
	public MemberDao memberDao() {
		System.out.println("memberDao() 생성");
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		System.out.println("memberRegisterService() 생성");
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrintService memberPrintService() {
		System.out.println("memberPrintService() 생성");
		return new MemberPrintService();
	}
	
	@Bean
	public MemberSearchService memberSearchService() {
		System.out.println("memberSearchService() 생성");
		return new MemberSearchService();
		
	}
	
}
