package com.yyp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理测试
 */
@Controller
public class Exception1Controller {

    /**
     * 测试出现异常的，由于设置了RequestParam 默认是必须有的，如果不传参name就会报错
     * @param name
     * @return
     */
    @RequestMapping("/exception01")
    public String exception01( @RequestParam(value = "name") String name){
        return "success";
    }

    /**
     * 在controller中增加ExceptionHandler力度更细优先级更高，但是只能拦截当前controller中的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView controlerException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
