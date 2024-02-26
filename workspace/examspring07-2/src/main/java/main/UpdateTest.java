package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import examspring.Member;
import examspring.MemberDao;

public class UpdateTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= 
				new ClassPathXmlApplicationContext("config-main.xml");
		
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = new Member("user8", "7457", "cguser2", null);
		//memberDao.update(member);
		memberDao.updateMap(member.getMemberpw(), member.getMemberid());
		

		
		
		ctx.close();
		
	}
}
