package aop15;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop15.xml");
		
		Target target = ctx.getBean("target", Target.class);
		int result = target.process("1234");
		System.out.println("결과:" + result);
	}
}
