package com.yyp.spring.controller.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyp.spring.entity.User;

/**
 * REST:一种客户端映射到服务端的架构设计
 * 使url更加优雅规范,广泛的应用在前后端分离分布式项目
 * 以下将演示增删改查功能各种restful方式的请求
 *
 * 注意：
 *  由于html还没有put，delete提交方式的实现，但是http实现了，所以所以需要一个过滤器对请求进行过滤将请求转换为put或者delete请求即可
 *  spring已经实现好了一个过滤器，只需在web.xml中进行配置即可
 *  过滤器的实现原理：
 *  1：页面提交使用post方式
 *  2：提交的表单中增加一个隐藏标签，标签中的name="_method" value="put"或者"delete"
 *  3：过滤器过滤请求时如果发现为post请求且获取到了"_method"的值，则将请求转换为put请求或者delete请求
 *
 *  问题：由于我们将请求转换问put或者delete请求所以在tomcat7以上的版本校验更加严格了，所以转发后会报错405
 *  解决方法：
 *      1 使用tomcat7
 *      2 返回方式不使用转发而是使用重定向 推荐
 *      3 自定义一个过滤器专门过滤转发类型的返回请求，将请求在改回post方式
 *      4 将jsp的page指定 isErrorPage属性改成true(不建议)
 */
//@RestController 在分布式前后端分离的项目专门做服务的api不用关前端的时候使用
// ，返回的也是json数据又不是页面名称，方法的映射方式相同，只有返回值方式不同，前后端分离是返回json数据
@Controller //在单体应用中使用rest风格使用这个注解就可以
@RequestMapping("/rest")
public class RestfulController {

    /**
     * GET请求方式做查询处理
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        System.out.println("GET方式查询用户");
        return "index";
    }

    /**
     * POST方式进行增加处理
     * @return
     */
    @PostMapping("/user")
    public String addUser(User user){
        System.out.println("POST方式增加用户");
        return "index";
    }

    /**
     * PUT方式修改用户
     * @param user
     * @return
     */
    @PutMapping("/user/{id}")
    public String modifyUser(User user){
        System.out.println("PUT方式增加用户");
        return "index";
    }

    /**
     * delete方式删除用户
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("DELETE方式增加用户");
        return "index";
    }


}
