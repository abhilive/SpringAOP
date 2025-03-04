package com.abhilive.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class EmployeeAspect {

    @Before(value = "execution(* com.abhilive.springaop.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "execution(* com.abhilive.springaop.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
    }

    @Before(value = "execution(* com.abhilive.springaop.service.EmployeeService.*(..))")
    public void beforeServiceAdvice(JoinPoint joinPoint) {
        System.out.println("Request to service layer " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "execution(* com.abhilive.springaop.service.EmployeeService.*(..))")
    public void afterServiceAdvice(JoinPoint joinPoint) {
        System.out.println("Request to service layer " + joinPoint.getSignature() + " ended at " + new Date());
    }

}
