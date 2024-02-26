package aop14;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Order(5)
public class AfterAspect2 {
	
	@After("execution(public Integer *.process(String))")
	public void after2(JoinPoint jp) {
		System.out.println("after2");
	}

}
