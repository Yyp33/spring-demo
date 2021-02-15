package com.yyp.spring.Entity;

import org.springframework.beans.factory.annotation.Value;

public class Wife {

    @Value("通过自定义Import选择器注入bean中Wife")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
