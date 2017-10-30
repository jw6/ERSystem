package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//import com.revature.service.*;
@Aspect
@Component("aspect")
public class AspectExample {
	
	@Before("execution(* pl*Co*(..))")
	public void highjackPlays(JoinPoint jp) {
		System.out.println("Highjacking the 2 play* methods");
	}
	
//	@After("execution(* *Show(..))")
//	public void highjackAfterPlay(JoinPoint jp) {
//		System.out.println("After play * methods ");
//	}
	
	@Around("execution(* run*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp)throws Throwable {
		System.out.println("set up rides");
		
		System.out.println(pjp.getSignature());
		pjp.proceed();
		System.out.println("clean up rides");
	}
	
}
