package aop15;

import org.aspectj.lang.JoinPoint;

public class AfterAspect2 {
	
	public void after2(JoinPoint jp) {
		System.out.println("after2");
	}

}
