package aop11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("aop11.xml");
		
		Person alice = ctx.getBean("progamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		
		try {
			int usedTime1 = alice.usingComputer("1234");
			System.out.println("alice의 사용시간: " + usedTime1);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		
		try {
			int usedTime2 = bob.usingComputer("5678");
			System.out.println("bob의 사용시간: " + usedTime2);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		ctx.close();
	
	}
}
