package com.yyp.spring.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("==================方法前执行======================preHandle");

        //当拦截的是springmvc请求时handler是HandlerMethod
        //如果拦截的非springmvc请求时handler就非HandlerMethod，所以这里需要加一个判断
        //由此可以看看出拦截器与过滤器的不同，拦截器可以获取拦截的方法信息，而过滤器不可以
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("方法执行的类："+handlerMethod.getBean().getClass());
            System.out.println("方法执行的方法："+handlerMethod.getMethod().getName());
            System.out.println("方法执行的参数："+ Arrays.asList(handlerMethod.getMethod().getParameters()));
        }

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("==================方法后执行，未进行视图渲染，如果执行方法发生异常不会执行======================postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("==================方法后执行，进行完视图渲染，如果方法出现异常也会执行======================afterCompletion");
    }
}
