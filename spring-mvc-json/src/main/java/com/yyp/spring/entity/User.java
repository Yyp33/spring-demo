package com.yyp.spring.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class User {

    private Integer id;
    private String name;
    @JsonIgnore//java对象转json格式时忽略此注解标记的字段
    private String psw;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //普通提交方式的字符转日期相互转换的数据格式化
    @JsonFormat(pattern = "yyyy-MM-dd")//json方式：请求/响应下字符转日期相互转换的数据格式化
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, String psw, Date birthday) {
        this.id = id;
        this.name = name;
        this.psw = psw;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
