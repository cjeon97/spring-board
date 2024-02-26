package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import examspring.MemberDao;

public class SelectAllTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		List<Member> memberList = memberDao.selectAll();
		
		for(Member m : memberList) {
			System.out.println(m.toString());
		}
	
		ctx.close();
	}
}
