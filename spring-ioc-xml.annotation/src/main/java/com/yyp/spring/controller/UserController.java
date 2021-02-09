package com.yyp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yyp.spring.Entity.User;
import com.yyp.spring.service.BaseService;
import com.yyp.spring.service.UserService;

@Controller
public class UserController {

    /**
     * 1、手动注入@Value("#{userServiceImpl}")
     * 2、 类的属性自动注入，自动注入的属性必须是对象且存在于ioc容器中
     *  @Autowired 优先根据类型进行匹配，然后根据名称去匹配，
     *  如果出现多个类型相同且没有名称相同的就会报错解决方案：
     *  1、修改属性的名称改成bean1的名字：userServiceImpl
     *  2、修改bean的名字 @service("userService")
     *  3、使用@Qualifier("userServiceImpl")设置属性在容器中查找的名字
     *  4、设置@Primary设置其中一个bean为主要的自动注入bean
     *  5、使用泛型限定
     *
     *  主要使用第二种方式
     *
     */
    @Autowired
    UserService userService;

    /*
    可以用在方法上也可以用在构造函数上
    @Autowired
    public void autoUserService(UserService userService){
        this.userService = userService;
    }*/

    @Autowired
    BaseService<User> baseService;

    public void getUser(){
        userService.getUser();
    }

    public void getObject(){
        baseService.getObject();
    }
}
