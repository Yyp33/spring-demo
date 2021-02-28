package com.yyp.spring.conversion;

import com.yyp.spring.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 自定义类型转换器
 * string-》User 需要实现Converter接口
 */
@Component
public class MyConversion implements Converter<String, User> {

    @Override
    public User convert(String s) {
        String[] userStrArr = s.split(",");
        User user = new User();
        user.setId(Integer.parseInt(userStrArr[0]));
        user.setName(userStrArr[1]);
        return user;
    }
}
