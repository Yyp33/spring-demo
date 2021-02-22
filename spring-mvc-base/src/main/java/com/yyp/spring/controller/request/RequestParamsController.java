package com.yyp.spring.controller.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yyp.spring.entity.User;
import com.yyp.spring.entity.UserDto;

/**
 *
 * 用于验证以及学习请求参数注入
 *
 * 处理乱码
 * GET: 在Tomcat的server.xml的配置文件中Connector节点加入URIEncoding="UTF-8"
 * POST:方法使用spring提供的过滤器
 */

@Controller
public class RequestParamsController {

    /**
     * RequestMapping 将方法映射给对应的url请求
     * @param name springmvc会将请求的参数自动封装到同名的局部变量中
     * @return
     */
    @RequestMapping("/Hello")
    public String hello(String name){
        System.out.println("我是"+name);

        //redirect 重定向
        //forward 转发 默认方式
        return "redirect:index.jsp";
    }

    /**
     *
     * @param age
     * @return
     * 参数会自动匹配，并且在参数类型准确的情况下自动转换类型
     * 如果类型不对，转换时会报错400
     * 如果不传入会自动赋值null
     * 匹配规则：
     * 参数名称与url中参数名称一致
     */
    @RequestMapping("/params01")
    public String params01(Integer age){
        System.out.println(age);
        return "index.jsp";
    }

    /**
     * 如果请求参数名称与方法参数名称不一致如何匹配
     * 使用注解@RequestParam("xxx") 输入请求参数名称
     * 使用了这个注解之后，默认url参数中必须包含xxx，否则会报错
     * value 用来重命名url参数
     * required 用来判断参数是否必须存在
     *          默认true
     * defaultValue 设置默认值当url中没传参，则使用默认值
     *          当设置了此值可以省略required
     */
    @RequestMapping("/params02")
    public String params02(@RequestParam(value = "userName",required = false, defaultValue = "222") String name){
        System.out.println(name);
        return "index.jsp";
    }

    /**
     *复杂数据类型
     * 对象：
     *  不用加入参数名称，直接传入对象的属性名称即可。
     *  如果是简单变量：id，name 直接输入属性名称即可
     *  如果是数组：一组的名字必须相同
     *  如果是list：需要加入索引下表[索引]如name="friends[0].name" 如果list中是string或者Integer基本数据可以省略下标
     *  如果是map：需要加入[key] 如name=“relative['father']”
     *  实体类只能给某个属性赋值：如name="role.name"
     */
    @RequestMapping("/params03")
    public String params03(User user){
        System.out.println(user);
        return "index.jsp";
    }

    /**
     *  form 表单提交情况下如果出现这种情况
     * public String params03(User user, Role roles) user与roles中都有id，name，因为表单中直接写对象的属性就可以，所以传过来之后就没办法区分是哪个对象的
     * 所以需要在封装一个对象比如
     * UserDTO 中包含user，role这样前台就可以传输user.id,role.id进行区分
     * 所以：如果出现多个对象：比如 （User user, Role role）或者List<User> users
     * 就在封装一层
     * @param userDto
     * @return
     */
    @RequestMapping("/params04")
    public String params04(UserDto userDto){
        System.out.println(userDto);
        return "index.jsp";
    }

    /**
     * 获取请求头信息
     * 如header中的host信息
     * 获取所有的信息使用map接收
     * @return
     */
    @RequestMapping("/header")
    public String header(@RequestHeader("Host") String host){
        System.out.println(host);
        return "index.jsp";
    }

    /**
     * 获取cookie的值
     * 比如获取cookies中的sessionID 可如下操作
     * 如果全部获取直接使用map接收即可
     * @param cookie
     * @return
     */
    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "index.jsp";
    }

    /**
     * servlet中的request以及response, session可以直接获取到
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/servlet")
    public String servlet(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        return "index.jsp";
    }
}
