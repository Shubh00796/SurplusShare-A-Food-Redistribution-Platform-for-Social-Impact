package com.FoodWasteManagementSystem.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class PerformanceAspect {

    @Around("execution(* com.FoodWasteManagementSystem.ServiceImpl.*.*(..))")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            log.debug("Method {} executed in {} nanoseconds", joinPoint.getSignature().toShortString(), executionTime);
            return result;
        } catch (Throwable e) {
            log.error("Error executing method {}: {}", joinPoint.getSignature().toShortString(), e.getMessage(), e);
            throw e;
        }
    }
}