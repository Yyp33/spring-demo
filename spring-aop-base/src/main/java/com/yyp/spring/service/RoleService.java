package com.yyp.spring.service;

import com.yyp.spring.Entity.Role;

public interface RoleService extends BaseService<Role> {

    public void add(Role role);
    public void delete(Integer id);
    public void get(Integer id);
}
