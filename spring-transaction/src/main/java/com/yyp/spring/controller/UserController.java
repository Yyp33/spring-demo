package com.yyp.spring.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.yyp.spring.entity.User;
import com.yyp.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void  getUser(){
        User user = userService.getUser();
        System.out.println(user);
    }
}
