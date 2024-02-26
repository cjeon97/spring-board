package examspring01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:config-main01.xml");
		
		FileProcess fp = ctx.getBean("fileProcess", FileProcess.class);
		fp.write("Data1");		
		System.out.println("프로그램 동작완료");
		
		ctx.close();
		System.out.println("프로그램 종료");
	}
}
