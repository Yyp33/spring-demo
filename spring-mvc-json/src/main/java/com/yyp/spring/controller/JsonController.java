package com.yyp.spring.controller;

import com.yyp.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/json")
public class JsonController {

    /**
     * 返回json格式数据
     * 1：依赖jackson 相关jar文件
     * 2：对应的方法上加入@ResponseBody注解
     * @return
     */
    @RequestMapping("/json01")
    @ResponseBody  //可以将返回值转化为json类型
    public String responseJson01(){
        return "json";
    }

    @RequestMapping("/json02")
    @ResponseBody  //可以将返回值转化为json类型
    public User responseJson02(){
        User user = new User(1, "2www");
        return user;
    }

    /**
     * 测试
 *     @JsonIgnore：java对象转json格式时忽略此注解标记的字段
     * @DateTimeFormat(pattern = "yyyy-MM-dd") //普通提交方式的字符转日期相互转换的数据格式化
     * @JsonFormat(pattern = "yyyy-MM-dd")//json方式：请求/响应下字符转日期相互转换的数据格式化
     */
    @RequestMapping("/json03")
    @ResponseBody
    public User responseJson03(){
        User user = new User(1, "2www","12333",new Date());
        return user;
    }


    /**
     * @RequestBody 接受json格式的数据，并转为javabean
     * 请求数据{"id":1,"name":"张三"}
     * @param user
     * @return
     */
    @RequestMapping("/json04")
    @ResponseBody
    public User requestJson01(@RequestBody User user){
        System.out.println(user);
        return user;
    }
    /**
     * {"id":1,"name":"张三"}
     * @RequestBody 接受json格式的数据，并转为javabean
     * @return
     */
    @RequestMapping("/json05")
    @ResponseBody
    public Map requestJson02(@RequestBody Map<String, Object> map){
        System.out.println(map);
        return map;
    }

    /**
     * [{"id":1,"name":"张三"},{"id":2,"name":"李四"}]
     * @RequestBody 接受json格式的数据，并转为javabean
     * @return
     */
    @RequestMapping("/json06")
    @ResponseBody
    public List<User> requestJson03(@RequestBody List<User> users){
        System.out.println(users);
        return users;
    }
    /**
     * "张三"
     * @RequestBody 接受json格式的数据，并转为javabean
     * @return
     */
    @RequestMapping("/json07")
    @ResponseBody
    public String requestJson04(@RequestBody String name){
        System.out.println(name);
        return name;
    }
}
