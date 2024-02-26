package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class UpdateTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		Member member = new Member("user3", "1234", "nnn3", null);
		memberDao.update(member);
		member = memberDao.selectOne("user3");
		System.out.println(member);
		
		//memberDao.updateMap("tester", "111111");

	}
}










