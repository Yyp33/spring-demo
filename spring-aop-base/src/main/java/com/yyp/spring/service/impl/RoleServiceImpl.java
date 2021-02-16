package com.yyp.spring.service.impl;

import com.yyp.spring.Entity.Role;
import com.yyp.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    public Role getObject() {
        System.out.println("泛型role");
        return null;
    }

    public void add(Role role) {
        System.out.println("增加一个角色");
    }

    public void delete(Integer id) {
        System.out.println("删除一个角色");
    }

    public void get(Integer id) {
        int i= 0/0;
        System.out.println("获取一个角色");
    }
}
