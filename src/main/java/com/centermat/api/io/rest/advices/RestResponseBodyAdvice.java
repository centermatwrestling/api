package com.centermat.api.io.rest.advices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

@RestControllerAdvice
@Slf4j
public class RestResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String fields = ((ServletServerHttpRequest) request).getServletRequest().getParameter("fields");
        if(Strings.isNullOrEmpty(fields)) {
            return body;
        }
        if(body instanceof Collection) {
            for (T t : (Collection<T>)body) {
                filter(t,fields);
            }
        } if(body instanceof Page) {
            for (T t : ((Page<T>) body).getContent()) {
                filter(t, fields);
            }
        } else {
            return filter(body, fields);
        }
        return body;
    }

    private T filter(T body, String fields) {
        Set<String> fieldSet = Sets.newHashSet(Splitter.on(",").split(fields));

        try {
            final BeanInfo beanInfo = Introspector.getBeanInfo(body.getClass());
            for (PropertyDescriptor prop : beanInfo.getPropertyDescriptors()) {
                if (!fieldSet.contains(prop.getName())) {
                    final Method writeMethod = prop.getWriteMethod();
                    if (writeMethod != null) {
                        writeMethod.invoke(body, new Object[]{null});
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unable to map fields",e);
        }
        return body;
    }
}
