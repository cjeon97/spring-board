package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class SelectAllTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		List<Member> ls = memberDao.selectAll();
		
		for(Member m : ls) {
			System.out.println(m);
		}
	}
}




