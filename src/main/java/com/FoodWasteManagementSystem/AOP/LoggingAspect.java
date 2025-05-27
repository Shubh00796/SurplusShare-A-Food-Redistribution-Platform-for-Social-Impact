package com.FoodWasteManagementSystem.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.FoodWasteManagementSystem.ServiceImpl.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before method call: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.FoodWasteManagementSystem.ServiceImpl.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After method call: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.FoodWasteManagementSystem.ServiceImpl.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("After returning from method call: {} with result: {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.FoodWasteManagementSystem.ServiceImpl.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("After throwing exception from method call: {} with exception: {}", joinPoint.getSignature().getName(), exception.getMessage());
    }
}