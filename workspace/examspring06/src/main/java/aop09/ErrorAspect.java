package aop09;

import org.aspectj.lang.JoinPoint;

public class ErrorAspect {

	public void error(JoinPoint jp) {
		String com = jp.getTarget().getClass().getSimpleName();
		System.out.println(com + "에 문제 발생 - AS신청");
	}
}
