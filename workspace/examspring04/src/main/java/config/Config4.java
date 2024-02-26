package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import examspring04.MemberDao;
import examspring04.MemberRegisterService;

@Configuration
@Import(Config3.class)
public class Config4 {
	
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
