package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import examspring04.MemberDao;
import examspring04.MemberPrintService;
import examspring04.MemberRegisterService;

@Configuration
public class Config6 {

	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrintService memberPrintService() {
		return new MemberPrintService();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao);
	}
	
}
