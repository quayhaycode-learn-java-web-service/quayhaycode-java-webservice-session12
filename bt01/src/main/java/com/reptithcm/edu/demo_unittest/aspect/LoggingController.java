package com.reptithcm.edu.demo_unittest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingController {

    @Before("execution(* com.reptithcm.edu.demo_unittest.controller.BookController.*(..))")
    public void loggingBeforeController(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + ": Logging before controller");
    }

    @AfterReturning(pointcut = "execution(* com.reptithcm.edu.demo_unittest.service.*(..))", returning = "result")
    public void loggingAfterReturning(JoinPoint joinPoint, Object result){
        log.info(joinPoint.getSignature().getName() +": Logging afterReturning with result: " + result );
    }

    @Around("execution(* com.reptithcm.edu.demo_unittest.controller.*.*(..))")
    public Object loggingAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start = System.currentTimeMillis();
        Object proceeding = joinPoint.proceed();

        long executionTime = System.currentTimeMillis();

        log.info("{} executed in {} ms", joinPoint.getSignature().getName(), executionTime - start);
        return proceeding;
    }

}
