package aop12;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ErrorAspect {

	@AfterThrowing("CommonPointcut.myPointcut()")
	public void error(JoinPoint jp) {
		String com = jp.getTarget().getClass().getSimpleName();
		System.out.println(com + "에 문제 발생 - AS신청");
	}
}
