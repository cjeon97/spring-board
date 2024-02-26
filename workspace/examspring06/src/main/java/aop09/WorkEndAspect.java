package aop09;

import org.aspectj.lang.JoinPoint;

public class WorkEndAspect {
	
	public void end(JoinPoint jp) {
		// get programmer or progamer
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "작업 종료");
	}
}
