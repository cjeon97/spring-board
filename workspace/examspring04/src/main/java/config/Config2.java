package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import examspring04.MemberDao;
import examspring04.MemberPrintService;
import examspring04.MemberSearchService;

@Configuration
public class Config2 {

	@Autowired
	//private MemberDao memberDao;
	private Config1 config1;
	
	@Bean
	public MemberPrintService memberPrintService() {
		System.out.println("memberPrintService() 생성");
		return new MemberPrintService();
	}
	
	@Bean
	public MemberSearchService memberSearchService() {
		System.out.println("memberSearchService() 생성");
		MemberSearchService mss = new MemberSearchService();
		//mss.setMemberDao(memberDao);
		mss.setMemberDao(config1.memberDao());
		mss.setMemberPrintService(memberPrintService());
		return mss;
	}
	
}
