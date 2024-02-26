package spring03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(
						"classpath:appContext3.xml");
		
		Greeter greeter1 = ctx.getBean("greeter1", Greeter.class);
		Greeter greeter2 = ctx.getBean("greeter2", Greeter.class);

		System.out.println(greeter1 == greeter2);
		
		ctx.close();
	}
}
