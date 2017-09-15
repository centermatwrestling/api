package com.centermat.api.io.rest.interceptors;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class RateLimitInterceptor extends HandlerInterceptorAdapter {
    private Cache<String,Integer> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String remoteAddr = request.getRemoteAddr();
        Integer count = cache.getIfPresent(remoteAddr);
        if(count == null) {
            count = 10;
        }
        count--;
        if(count<0) {
            count=0;
        }
        cache.put(remoteAddr,count);
        response.setHeader("X-Rate-Limit-Limit","10");
        response.setHeader("X-Rate-Limit-Remaining", String.valueOf(cache.getIfPresent(request.getRemoteAddr())));

        if(count<=0){
//            response.sendError(429, "Too Many Requests!");
//            return false;
        }
        return true;
    }

}
