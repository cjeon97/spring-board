package aop10;

import org.aspectj.lang.ProceedingJoinPoint;

public class WorkAspect {

	public Object work(ProceedingJoinPoint pjp) {
		String computer = pjp.getTarget().getClass().getSimpleName();
		String pwd = (String)pjp.getArgs()[0];
		System.out.println("[컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인]");
		
		Object result = null;
		try {
			//프로게이머/프로그레머의 usingComputer()를 호출(핵심기능)
			result = pjp.proceed(); 
			System.out.println(computer + "작업 종료");
		} catch (Throwable e) {
			System.out.println(computer + "에 문제 발생 - AS신청");
		}
		System.out.println(computer + " 시스템 종료");
		
		return result;
	}
	
}
