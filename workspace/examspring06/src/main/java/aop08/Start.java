package aop08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("aop08.xml");
		
		Person alice = ctx.getBean("progamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		
		int usedTime1 = alice.usingComputer("1234");
		System.out.println("alice의 사용시간: " + usedTime1);
		System.out.println();
		
		int usedTime2 = bob.usingComputer("5678");
		System.out.println("bob의 사용시간: " + usedTime2);
		
		ctx.close();
	
	}
}
