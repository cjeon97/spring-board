package aop14;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Order(5)
public class BeforeAspect2 {
	
	@Before("execution(public Integer *.process(String))")
	public void before2(JoinPoint jp) {
		System.out.println("before2");
	}

}
