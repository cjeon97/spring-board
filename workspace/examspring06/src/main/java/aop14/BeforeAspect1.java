package aop14;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Order(6)
public class BeforeAspect1 {
	
	@Before("execution(public Integer *.process(String))")
	public void before1(JoinPoint jp) {
		System.out.println("before1");
	}

}
