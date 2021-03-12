package com.yyp.spring.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
    private Integer id;
//    @NotEmpty(message = "邮件不能为空") 将message信息写入到资源文件中，格式：NotEmpty.user.username=邮件不能为空! 注解.对象.属性
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
