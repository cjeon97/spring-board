package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class InsertTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		Member member = new Member("user9", "1234", "nnn9", null);
		memberDao.insert(member);
		System.out.println(member);

		
		
		ctx.close();
		
	}
}
