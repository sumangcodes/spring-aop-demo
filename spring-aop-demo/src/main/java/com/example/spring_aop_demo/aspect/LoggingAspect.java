package com.example.spring_aop_demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Aspect: This class contains the cross-cutting concerns (e.g., logging) and is marked with @Aspect to indicate its role.
@Aspect
@Component // Marks this class as a Spring-managed component
class LoggingAspect {

    // Before Advice: Executes before any method in the specified package and its
    // sub-packages.
    // The pointcut expression "execution(* com.example.demo..*(..))" matches any
    // method in "com.example.demo" and its sub-packages.
    @Before("execution(* com.example.spring_aop_demo..*(..))")
    public void logBefore() {
        System.out.println("[Before Advice] Method execution started");
    }

    // After Advice: Executes after the method completes, regardless of its outcome
    // (success or exception).
    @After("execution(* com.example.spring_aop_demo..*(..))")
    public void logAfter() {
        System.out.println("[After Advice] Method execution completed");
    }

    // After Returning Advice: Executes after a method successfully completes and
    // logs the returned value.
    // "pointcut" specifies the matched methods, and "returning" binds the returned
    // value to the "result" parameter.
    @AfterReturning(pointcut = "execution(* com.example.spring_aop_demo..*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("[After Returning Advice] Returned value: " + result);
    }

    // After Throwing Advice: Executes if a method throws an exception.
    // "pointcut" specifies the matched methods, and "throwing" binds the exception
    // to the "error" parameter.
    @AfterThrowing(pointcut = "execution(* com.example.spring_aop_demo..*(..))", throwing = "error")
    public void logAfterThrowing(Exception error) {
        System.out.println("[After Throwing Advice] Exception thrown: " + error.getMessage());
    }

    // Around Advice: Wraps the method execution, allowing behavior both before and
    // after the method call.
    // Uses "ProceedingJoinPoint" to execute the target method and retrieve its
    // result or handle exceptions.
    @Around("execution(* com.example.spring_aop_demo..*(..))")
    public Object logAround(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around Advice] Before method execution");
        Object result;
        try {
            // Proceed with the target method execution
            result = joinPoint.proceed();
        } catch (Exception e) {
            // Log exception details and rethrow the exception
            System.out.println("[Around Advice] Exception: " + e.getMessage());
            throw e;
        }
        System.out.println("[Around Advice] After method execution");
        return result;
    }
}
