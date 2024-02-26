package aop15;

import org.aspectj.lang.JoinPoint;

public class BeforeAspect1 {
	
	public void before1(JoinPoint jp) {
		System.out.println("before1");
	}

}
