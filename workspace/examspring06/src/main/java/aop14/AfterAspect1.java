package aop14;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Order(6)
public class AfterAspect1 {
	
	@After("execution(public Integer *.process(String))")
	public void after1(JoinPoint jp) {
		System.out.println("after1");
	}

}
