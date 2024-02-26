package aop15;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

public class AfterAspect1 {
	
	public void after1(JoinPoint jp) {
		System.out.println("after1");
	}

}
