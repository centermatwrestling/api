package com.centermat.api.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Slf4j
public class StatsAspect {

    @Around("@within(Timed)")
    public Object processSystemRequest(final ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        try {
            logPerformance(pjp, start);
        } catch (Throwable t) {
            log.warn("Error logging the Performance. This is not expected.", t);
        }
        return retVal;
    }

    private void logPerformance(ProceedingJoinPoint pjp, long start) {
        long end = System.currentTimeMillis();
        long differenceMs = end - start;

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        //get the value of timing notes as declared in the method annotation
        //String requestInfo = param.getRequestInfo();
        log.debug(targetMethod.getDeclaringClass().getName() + "." + targetMethod.getName() + " took " + differenceMs + " ms" + " request info : ");
    }

}
