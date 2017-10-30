package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("aspect")
public class AspectExample {
	
	@Before("execution(* com.revature.service.AppService.play*(..))")
	public void highjackPlays(JoinPoint jp) {
		System.out.println("Highjacking the 2 play* methods");
	}
	
}
