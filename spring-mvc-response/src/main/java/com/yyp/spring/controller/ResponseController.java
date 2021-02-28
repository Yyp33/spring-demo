package com.yyp.spring.controller;

import com.yyp.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/response")
public class ResponseController {

    /**
     * 配置视图解析器后，只需写文件名，视图解析器会帮我们增加文件后缀以及前缀
     * @return
     */
    @RequestMapping("/response01")
    public String response01(){
        return "main";
    }

    /**
     * 如果不想走视图解析器自己手写界面文件所在路径
     * 加入forwar关键字即可
     * @return
     */
    @RequestMapping("/response02")
    public String response02(){
        System.out.println("不使用视图解析器，访问非web-inf文件下的index界面");
        return "forward:/index.jsp";
    }

    /**
     * 重定向
     * 与视图解析器无关
     * @return
     */
    @RequestMapping("/response03")
    public String response03(){
        System.out.println("不使用视图解析器，访问非web-inf文件下的index界面");
        return "redirect:/index.jsp";
    }

    /**
     *
     * springmvc会将请求的参数隐藏式的重新写到隐藏域中
     *
     * 但是只有对象可以，基本类型不可以比如String，Integer
     * @return
     */
    @RequestMapping("/response04")
    public String response04(User user){
        System.out.println("接收的参数隐藏式的放到request中返回前台"+user);
        return "main";
    }

    /**
     * 接收不会自动的返回给前台
     * @return
     */
    @RequestMapping("/response05")
    public String response05(@RequestParam("name") String name, Integer id){
        System.out.println("接收不会自动的返回给前台"+name);
        //要返回只能通过model
        return "main";
    }
}
