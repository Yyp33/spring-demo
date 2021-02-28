package com.yyp.spring.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 数据后台校验
 * 所有的可用注解可参看有道云笔记：04-SpringMVC基于注解使用：类型转换&数据格式化&数据验证中
 */

@Component
public class User {
    @NotNull(message = "id不能是null") //不能是空
    @Min(value = 1,message = "id最小值是1")//数值需要>=1
    private Integer id;
    @Length(min = 4,max = 10,message ="姓名字符长长度{min}至{max}" )//名称需要大于4等于四个字符小于10个字符
    @Pattern(regexp = "^[0-9a-zA-z]+$",message = "姓名字符串长度只能是数字以及字母组成")//使用正则表达式校验
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//数据格式化，用于将相应的字符串转化为date类型非数据校验
    @Past(message = "出生日期不能大于当前日期")//需要是现在之前的日期
    private Date birthday;
    private String hobbies;
//    @Digits(integer = 100,fraction = 10000)//必须是数字，且在一定范围
    @Range(min = 10000,max = 15000,message = "工资在{min}至{max}")//非int类型使用range
    private Double money;
    @Size(min = 1,max = 150, message = "年龄在{min}至{max}")
    private Integer age;
    @NotEmpty//字符串非空
    @Email(message = "输入正确的邮箱格式")
    private String email;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", hobbies='" + hobbies + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}
