package com.yyp.spring.controller.request;

import com.yyp.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.UserDataHandler;

/**
 * @PathVariable: 用于获取请求路径url中的参数,并自动注入到方法的参数中
 * 分为两种情况
 * 一：方法参数是基本类型对象而非自定义对象
 *      如Integer,String,Long
 *      url映射设置：@RequestMapping("/path01/{id}/{userName}")
 *      方法参数注入：    public String path01(@PathVariable("id") Integer id, @PathVariable("userName") String name){
 *      注意：
 *          即使方法参数与url中定义的参数名称相同也得使用@PathVariable
 * 二：方法参数是一个自定义的对象
 *      url映射设置：@RequestMapping("/path01/{id}/{userName}")
 *      方法参数注入：public String path02(User user)
 *      注意
 *          url中设置的参数名称必须与方法参数对象的属性一直才可以
 *          不用使用@PathVariable注解
 */
@Controller
@RequestMapping("/path")
public class PathVariableController {

    /**
     * 测试url rest方式基本参数设置以及获取
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/path01/{id}/{userName}")
    public String path01(@PathVariable("id") Integer id, @PathVariable("userName") String name){
        System.out.println("基本数据类型获取url参数");
        System.out.println(id);
        System.out.println(name);
        return "/index.jsp";
    }

    /**
     * 测试url rest方式自定义对象获取url中的参数
     * @param user
     * @return
     */
    @RequestMapping("/path02/{id}/{name}")
    public String path02(User user){
        System.out.println("自定义数据类型数据类型获取url参数");
        System.out.println(user);
        return "/index.jsp";
    }
}
