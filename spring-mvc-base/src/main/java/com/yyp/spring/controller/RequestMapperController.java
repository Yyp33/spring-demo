package com.yyp.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 学习请求映射
 * @RequestMapping
 *  既可以标注到类上也可以标注到方法上
 *  标注到类上，方法上的映射前都要加上类上的映射，目的是为了区分
 *  如下相应映射到mapper01url就得是/mapper/mapper01
 */
@Controller
@RequestMapping("/mapper")
public class RequestMapperController {
    /**
     * @RequestMapping就是用来标识此方法用来处理什么请求其中的/可以取消
     * 取消后默认也是从当前项目的根目录开始查找，一般在编写的时候看个人习惯
     * 同时，@RequestMapping也可以用来加在类上，
     * value:要匹配的请求
     */

    @RequestMapping("/mapper01")
    public String requestMap01(){
        return "/index.jsp";
    }

    /**
     * @RequestMapping的METHOD：
     * 限制发送请求的方式： POST GET
     * 默认不区分请求方法
     * post请求方式
     *  @RequestMapping( value = "/mapper02", method = RequestMethod.POST)
     * get请求方式
     * @RequestMapping( value = "/mapper02", method = RequestMethod.GET)
     * 可同时设置多个请求方式
     *@RequestMapping( value = "/mapper02", method = {RequestMethod.GET, RequestMethod.POST})
     * @return
     */
    @RequestMapping( value = "/mapper02", method = {RequestMethod.GET, RequestMethod.POST})
    public String requestMap02(){
        return "/index.jsp";
    }

    /**
     * 请求方式， spring4.3之后的post，get为了方便新增了注解
     * post 方式@PostMapping("/mapper03")等同于@RequestMapping( value = "/mapper02", method = RequestMethod.POST)
     * get 方式@PostMapping("/mapper03")等同于@RequestMapping( value = "/mapper02", method = RequestMethod.GET)
     *
     */
    @GetMapping("/mapper03")
    public String requestMap03(){
        return "/index.jsp";
    }


    /**
     * 请求方式， spring4.3之后的post，get为了方便新增了注解
     * params:用来限制哪些属性必须要有，哪些属性不能有，哪些属性的值必须是什么，哪些属性的值不能是什么
     *      params="{userName}" 请求需要参数需要包含userName
     *      params="{!userName}" 请求需要参数不能包含userName
     *      params="{userName="xxx"}" 请求需要参数userName的值得是xxx
     *      params="{userName!="xxx"}" 请求需要参数userName的值不能是xxx
     *
     */
    @RequestMapping(value = "/mapper04",params = "{userName;!name,desc='xxx',desc!='ccc'}")
    public String requestMap04(){
        return "/index.jsp";
    }
}
