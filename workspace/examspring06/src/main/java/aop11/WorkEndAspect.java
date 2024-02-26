package aop11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WorkEndAspect {
	
	@AfterReturning("CommonPointcut.myPointcut()")
	public void end(JoinPoint jp) {
		// get programmer or progamer
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "작업 종료");
	}
}
