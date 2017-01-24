package com.centermat.api.io;

import com.centermat.api.model.BaseModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Aspect
@Component
public class RestAspect {
    @Autowired
    HttpServletRequest request;

    @AfterReturning(pointcut = "within(com.centermat.api.io.rest..*)", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        if(result instanceof BaseModel) {
            updateModel(request, (BaseModel) result);
        }
        if(result instanceof Iterable) {
            for (Object o : (Iterable)result) {
                if(o instanceof BaseModel) {
                    updateModel(request, (BaseModel) o);
                }
            }
        }
    }

    private void updateModel(HttpServletRequest request, BaseModel one) {
        final String url = request.getRequestURL().toString().replaceAll("(.*//.*?)/.*", "$1");
        if(!one.getLink().startsWith(url)) {
            one.setLink(url + one.getLink());
        }
    }
}
