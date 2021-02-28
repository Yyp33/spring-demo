package com.yyp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *  1、后台传递参数到到前台的方式Model,Map,ModelMap功能相同可以随便使用任何方式，底层都是调用request
 *  2、springmvc还会隐式的将前台请求的参数在绑定到request中在此返回前台
 *
 *
 */
@Controller
@RequestMapping("/output")
public class OutputController {

    /**
     * 通过servlet-api向前台返回数据
     * @return
     */
    @RequestMapping("/output01")
    public String output01(HttpServletRequest request){
        request.setAttribute("type","servlet-api:request");
        return "main";
    }

    /**
     * 通Model过向前台返回数据
     * @return
     */
    @RequestMapping("/output02")
    public String output02(Model model){
        model.addAttribute("type","model");
        return "main";
    }

    /**
     * 通ModelMap过向前台返回数据
     * @return
     */
    @RequestMapping("/output03")
    public String output03(ModelMap modelMap){
        modelMap.addAttribute("type","ModelMap");
        return "main";
    }

    /**
     * 通ModelMap过向前台返回数据
     * @return
     */
    @RequestMapping("/output04")
    public String output04(Map map){
        map.put("type","ModelMap");
        return "main";
    }
    /**
     * 通ModelAndView过向前台返回数据
     * @return
     */
    @RequestMapping("/output05")
    public ModelAndView output05(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type","ModelAndView");
        modelAndView.setViewName("main");
        return  modelAndView;
    }

    @Autowired
    HttpSession session;

    /**
     * 使用session传输数据
     * 三种方式
     *  1、使用servlet-api的方式-方法内的参数线程安全
     *  2、使用自动注入的方式-自动注入虽然是类的公共属性，但是注入的是对象放在线程的threadLocal里边所以也是线程安全的（推荐使用）
     *  3、使用spring提供的@SessionAttributes和@SessionAttitude注解（不推荐使用过于繁琐）
     *      @SessionAttributes放在类上使用方法@SessionAttributes("XXXX"),然后就会找类的方法中model中用没有key为xxxx的
     *      配置，如果有则将值拷贝一份放入session中
     *      @SessionAttribute放在方法的参数上，用于去除session中的值注入到方法参数中
     *      model和session是互通的：session可以通过model中去获取写入指定的属性， model也会从session中自动写入指定的属性
     * @return
     */
    @RequestMapping("/session01")
    public String session01(){
        session.setAttribute("type","session");
        return "main";
    }

    /**
     * 测试@SessionAttribute
     * @return
     */
    @RequestMapping("/session02")
    public String session02(@SessionAttribute("type") String type){
        System.out.println(type);
        return "main";
    }

    /**
     * @ModelAttribute注解的方法会在类所有方法执行之前执行
     *
     * @return
     */
    @ModelAttribute
    public void modelAttribute(){
        System.out.println("modelAttribute");
    }
}
