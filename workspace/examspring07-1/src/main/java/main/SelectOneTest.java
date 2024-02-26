package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.MemberDao;

public class SelectOneTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao.selectOne("tester1"));
		
		
		ctx.close();
		
	}
}
