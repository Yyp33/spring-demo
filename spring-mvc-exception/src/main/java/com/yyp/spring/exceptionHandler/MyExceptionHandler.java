package com.yyp.spring.exceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 配置全局异常处理
 */
@ControllerAdvice//controller注解的升级版可以进行全局配置
public class MyExceptionHandler {

    /**
     * 全局的异常处理方法任何优先级低于在控制层中写的异常处理方法
     * 同时也低于全局中能匹配到具体异常类的处理方法，现在的类是Exception最广泛
     *
     * 兼容ajax请求返回json格式数据
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView controlerException(HttpServletRequest request
            , HttpServletResponse response
            , HandlerMethod handle
            , Exception e){
        //1.判断是否为ajax请求
        //方式一：判断是否使用的相应的注解
        RestController restController = handle.getClass().getAnnotation(RestController.class);//获取类上的某个注解
        ResponseBody annotation = handle.getMethod().getAnnotation(ResponseBody.class);//获取方法上的某个注解
//        if(restController!=null && annotation!=null){//ajax请求
        //方式二：判断请求头中的请求格式
        if(request.getHeader("Accept").indexOf("application/json")>-1){
            //加入MappingJackson2JsonView就会返回json
            ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
            modelAndView.addObject("error",e.getMessage());
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("error", e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }
}
