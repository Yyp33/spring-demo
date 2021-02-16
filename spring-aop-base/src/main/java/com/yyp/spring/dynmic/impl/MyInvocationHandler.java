package com.yyp.spring.dynmic.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        try{
            System.out.println("方法执行参数"+ Arrays.asList(args));
            invoke = method.invoke(object, args);
            System.out.println("方法执行结果");
        }catch (Exception exception){
            System.out.println("出现异常"+exception);
        }

        return invoke;
    }
}
