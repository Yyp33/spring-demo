package com.second.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用来测试引入其他配置类是否生效
 */
@Component
public class TestSecondConfig {

    @Value("通过其他配置类注入")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TestSecondConfig{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
