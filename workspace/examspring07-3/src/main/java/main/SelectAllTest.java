package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import repository.mapper.MemberMapper;

public class SelectAllTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberMapper memberDao = ctx.getBean("memberMapper", MemberMapper.class);
		List<Member> memberList = memberDao.selectAll();
		
		for(Member m : memberList) {
			System.out.println(m.toString());
		}
	
		ctx.close();
	}
}
