package aop15;

import org.aspectj.lang.JoinPoint;

public class BeforeAspect2 {
	
	public void before2(JoinPoint jp) {
		System.out.println("before2");
	}

}
