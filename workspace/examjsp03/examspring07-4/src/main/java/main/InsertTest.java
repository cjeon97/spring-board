package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class InsertTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		Member member = new Member("testuser2", "1234", "nnn3", null);
		System.out.println(member);
		memberDao.insert(member);
		System.out.println(member);
		
	}
}










