package com.yyp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义拦截器配置不皱
 * 1、实现HandleInterceptor接口
 * 2、配置文件中进行<mvc:interceptor></mvc:interceptor>配置
 */
@Controller
public class InterceptorController {

    /**
     * 拦截器方法执行顺序
     * preHandle-》postHandle-》afterCompletion
     *
     * 过滤器与拦截器的执行顺序
     * 过滤器前-》preHandle-》postHandle-》afterCompletion-》过滤器后
     *
     * 过滤器与拦截器的区别
     * 1、过滤器依赖于servlet容器，拦截器依赖于springmvc
     * 2、过滤器可以拦截所有请求包括资源映射，拦截器只能拦截springmvc请求
     * 3、过滤去无法获取请求的上下文，拦截器可以获取上下文比如执行的类，方法，参数等等
     *
     * 不同的拦截器的执行顺序与配置文件的配置顺序有关
     * @return
     */
    @RequestMapping("/interceptor01")
    public String interceptor01(){
        return "success";
    }

    /**
     * 测试出现异常时是不走postHandle走afterCompletion方法
     * @return
     */
    @RequestMapping("/interceptor02")
    public String interceptor02(){
        int i=1/0;
        return "success";
    }

    /**
     * 测试拦截器可以获取拦截方法的类，方法，以及参数
     * @return
     */
    @RequestMapping("/interceptor03")
    public String interceptor03(String name){
        System.out.println(name);
        return "success";
    }

}
