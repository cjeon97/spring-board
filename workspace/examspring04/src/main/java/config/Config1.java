package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import examspring04.MemberDao;
import examspring04.MemberRegisterService;

@Configuration
public class Config1 {
	
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
	
}
