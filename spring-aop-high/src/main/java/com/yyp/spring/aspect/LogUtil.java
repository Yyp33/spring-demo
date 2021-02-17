package com.yyp.spring.aspect;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //标记为切面
@Component //注入到springIOC
public class LogUtil {

    @Pointcut("execution(* com.yyp.spring.service..*.*(..))")
    public void pointcut(){}

    /**
     * execution 力度比较细，可以匹配到类级别以及方法级别
     * @Before("execution(* com.yyp.spring.service..*.*(..))")
     * within
     * @Before("within(com.yyp.spring.service.impl.RoleServiceImpl)")
     * @annotation 匹配注解
     *  @Before("@annotation(jdk.nashorn.internal.runtime.logging.Logger)")
     */
//    @Before("@annotation(jdk.nashorn.internal.runtime.logging.Logger)&&execution(* com.yyp.spring.service..*.*(..))")
    @Before("@annotation(jdk.nashorn.internal.runtime.logging.Logger)&&pointcut()")//切点表达式抽离
    public static void start(JoinPoint joinPoint){
        System.out.println("方法前");
        String methodName = joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        System.out.println(methodName+"方法开始执行，参数是："+ Arrays.asList(objects));
    }

//    @After(value = "execution(* com.yyp.spring.service..*.*(..))&&@annotation(logger)")
    @After(value = "pointcut()&&@annotation(logger)")//切点表达式抽离
    public static void stop(JoinPoint joinPoint, Logger logger){
        System.out.println("方法后");
        System.out.println("注解信息"+logger.name());
    }

//    @AfterThrowing(value = "execution(* com.yyp.spring.service..*.*(..))"
//            , throwing="e")
    @AfterThrowing(value = "pointcut()"
            , throwing="e")//切点表达式抽离
    public static void logException(JoinPoint joinPoint, Exception e){
        System.out.println("方法异常"+e);
    }

//    @AfterReturning(value = "execution(* com.yyp.spring.service..*.*(..))"
//            ,returning = "result" )
    @AfterReturning(value = "pointcut()"
            ,returning = "result" )//切点表达式抽离
    public static void end(JoinPoint joinPoint, Object result){
        System.out.println("方法结束,返回结果"+result);
    }


    @Around("pointcut()")
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
