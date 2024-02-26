package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import examspring.MemberDao;

public class InsertTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = new Member("user5", "1234", "nnn5", null);
		System.out.println(member.getNo());
		memberDao.insert(member);
		System.out.println(member.getNo());

		
		
		ctx.close();
		
	}
}
