package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class UpdateTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		Member member = new Member("user8", "7407", "cguser2", null);
		memberDao.update(member);
		

		
		
		ctx.close();
		
	}
}
