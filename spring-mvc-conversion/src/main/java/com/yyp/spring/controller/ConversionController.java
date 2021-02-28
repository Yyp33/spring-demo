package com.yyp.spring.controller;

import com.yyp.spring.entity.User;
import com.yyp.spring.entity.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试类型转换以及数据格式话
 */
@RequestMapping("/conversion")
@Controller
public class ConversionController {

    /**
     * 测试自定义类型转化器
     * String->User
     * url:/conversion/conversion01?user=1,ccc
     * 通过自定义类型转换器会讲1，cc转换为userDto中user对象的id以及name属性
     * @return
     */
    public String conversion01(UserDto userDto){
        System.out.println(userDto);
        return "main";
    }

    /**
     * 测试数据格式话
     * @DateTimeFormat("yyyy-MM-dd")
     * url:/conversion/conversion02?id=1&date=2020/10/10
     * 会自动将2020/10/10自动转换为日期类型注入到user的date属性中
     * 注意：如果代码中配置同时配置了自定义的类型转化器，转换器的bean需要由ConversionServiceFactoryBean
     *     改为FormattingConversionServiceFactoryBean
     *
     * 页面展示使用spring标签会自动显示格式化以后的日期如2020/10/10
     *
     *
     * 另外的数据格式化注解@NumberFormat由于用处不大可以参看有道云笔记
     * @return
     */
    public String conversion02(User user){
        return "user";
    }
}
