package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import examspring.MemberDao;

public class SelectOneTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = memberDao.selectOne("tester1");
		System.out.println(member.toString());
		
		
		ctx.close();
		
	}
}
