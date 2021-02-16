package com.yyp.spring.dynmic.impl;

import java.lang.reflect.Proxy;

/**
 * jdbc动态代理
 * 或者这个类也可以是一个公共类，用于生成动态代理
 * 被代理的类必须实现了接口
 */
public class JDBCProxyUtils {

    /**
     * 此方法可以对传入的对象创建一个代理类，并通过自定义的处理函数，输出传入值的日志信息
     * @param object
     */
    public static Object getProxy(Object object){
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        Object o = Proxy.newProxyInstance(classLoader, interfaces, new MyInvocationHandler(object));
        return o;
    }
}
