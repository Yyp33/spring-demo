package com.yyp.spring.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Value("1")
    private Integer id;
    /*
    使用value赋值的方式
    1、写死固定值，如：@Value("测试Value注解")
    2、使用${} 读取属性文件中的值 @Value("${mysql.username}")
    3、使用#{} 使用SPEL表达式"#{role.name}"
     */
    @Value("#{role.name}")
    private String name;
    private String gender;
    private String desc;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
