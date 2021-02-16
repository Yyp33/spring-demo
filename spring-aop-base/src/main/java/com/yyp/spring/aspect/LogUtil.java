package com.yyp.spring.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LogUtil {

    @Before("execution(* com.yyp.spring.service..*.*(..))")
    public static void start(){
        System.out.println("方法前");
//        System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(objects));
    }

    @After("execution(* com.yyp.spring.service..*.*(..))")
    public static void stop(){
        System.out.println("方法后");
        //        System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(objects));

    }

    @AfterThrowing("execution(* com.yyp.spring.service..*.*(..))")
    public static void logException(){
        System.out.println("方法异常");
        //        System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
    }

    @AfterReturning("execution(* com.yyp.spring.service..*.*(..))")
    public static void end(){
        System.out.println("方法结束");
//        System.out.println(method.getName()+"方法执行结束了......");
    }
}
