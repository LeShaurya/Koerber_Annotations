package com.example.services.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(Loggable)")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = methodSignature.getMethod().getName();
        logger.info("Entering method: {}", name);
        long startTime = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        startTime = System.currentTimeMillis() - startTime;
        logger.info("Time taken for operation: {}", startTime);
        return res;
    }
}
