package examspring04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("config-main04.xml");
		
		FileProcess fp1 = ctx.getBean("fileProcess", FileProcess.class);
		FileProcess fp2 = ctx.getBean("fileProcess", FileProcess.class);		
		System.out.println(fp1==fp2);
		
		FileProcess fp3 = ctx.getBean("fileProcess2", FileProcess.class);
		FileProcess fp4 = ctx.getBean("fileProcess2", FileProcess.class);
		System.out.println(fp3==fp4);
		
		ctx.close();
		System.out.println("프로그램 종료");
	}
}
