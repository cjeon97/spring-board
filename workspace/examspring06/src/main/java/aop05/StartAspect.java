package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StartAspect {	
	
	@Before("execution(public int aop05.*.usingComputer(String))")
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("[컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인]");
	}
}
