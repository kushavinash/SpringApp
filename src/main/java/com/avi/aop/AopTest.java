package com.avi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect

public class AopTest {
	
	@Before("execution(* controller.HelloWorldRestController.getStudentDetail(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@After("execution(* controller.HelloWorldRestController.getStudentDetail(..))")
	public void logAfter(JoinPoint joinpoint){
		
		
		System.out.println("logafter  is running!");
		System.out.println("avi: " + joinpoint.getSignature().getName());
		System.out.println("******");
		
	}
	
	
	@Around("execution(* controller.HelloWorldRestController.getStudentDetail(..))")
	public Object logRound(ProceedingJoinPoint joinPoint){
		 System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
	     Object object =null;
	        	try {
	        		object=	joinPoint.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       
	        System.out.println("****LoggingAspect.logAroundCreateEmployee() : " + joinPoint.getSignature().getName() + ": After Method Execution");
		return object;
	}

}
