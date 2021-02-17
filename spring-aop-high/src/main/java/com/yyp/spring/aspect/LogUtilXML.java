package com.yyp.spring.aspect;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LogUtilXML {




    public static void start(JoinPoint joinPoint){
        System.out.println("方法前");
        String methodName = joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        System.out.println(methodName+"方法开始执行，参数是："+ Arrays.asList(objects));
    }


    public static void stop(JoinPoint joinPoint){
        System.out.println("方法后");
    }

    public static void logException(JoinPoint joinPoint, Exception e){
        System.out.println("方法异常"+e);
    }


    public static void end(JoinPoint joinPoint, Object result){
        System.out.println("方法结束,返回结果"+result);
    }



    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知:"+name+"方法开始，参数是"+Arrays.asList(args));
            //利用反射调用目标方法，就是method.invoke()
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("环绕返回通知:"+name+"方法返回，返回值是"+proceed);
        } catch (Throwable e) {
            System.out.println("环绕异常通知"+name+"方法出现异常，异常信息是："+e);
        }finally {
            System.out.println("环绕后置通知"+name+"方法结束");
        }
        return proceed;
    }
}
