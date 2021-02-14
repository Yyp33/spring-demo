package com.yyp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yyp.spring.Entity.User;
import com.yyp.spring.service.BaseService;
import com.yyp.spring.service.UserService;

@Controller
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    BaseService<User> baseService;

    public void getUser(){
        userService.getUser();
    }

    public void getObject(){
        baseService.getObject();
    }
}
