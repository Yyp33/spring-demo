package com.yyp.spring.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yyp.spring.entity.Hobby;
import com.yyp.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataValidateController {

    /**
     *普通form提交方式
     * 自动校验数据
     * 1: 类的属性加入相应的验证注解
     * 2：在需要校验的对象上加入@Valid注解，才会执行校验
     * 3：可以用bindingResult来获取是否出现校验异常，如果自己不错处理页面会报错400异常，可以自己处理
     *     将异常返回增加界面。并做数据回显，Springmvc会自动将传入的参数在封装到request中可用于数据回显
     *     ，可以将校验报错信息放入到model传给前台
     */
    @RequestMapping("/dataValidate01")
    public String dataValidate01(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){//如果校验有异常
            Map<String, String> errorMap = new HashMap<String, String>();//key 属性名称，value：报错信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError:fieldErrors){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errorMap",errorMap);//将错误信息返回给前台
            return "add";
        }
        System.out.println(user);
        return "show";
    }


    @RequestMapping("/toSpringFormAddPage")
    public String toSpringFormAddPage(User user, Model model){
        System.out.println("跳转到spring form标签库的增加用户界面，到这个界面的时候需要model中包含一个user，即使是空的！");
        System.out.println("springmvc会自动将user加入到model中");
        List<String> hobbiesList = new ArrayList<String>();
        hobbiesList.add("唱歌");
        hobbiesList.add("跳舞");
        Map<String, String> hobbiesMap = new HashMap<String, String>();
        hobbiesMap.put("1", "唱歌");
        hobbiesMap.put("2", "跳舞");

        List<Hobby> hobbiesObjList = new ArrayList<Hobby>();
        hobbiesObjList.add(new Hobby("1","唱歌"));
        hobbiesObjList.add(new Hobby("2","跳舞"));
        model.addAttribute("hobbiesList",hobbiesList);
        model.addAttribute("hobbiesMap",hobbiesMap);
        model.addAttribute("hobbiesObjList",hobbiesObjList);
        return "springFormAdd";
    }
    /**
     *spring form标签库
     *使用这个标签到达这个界面时model中需要包含一个user对象，即使这个对象是个空对象
     */
    @RequestMapping("/dataValidate02")
    public String dataValidate02(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){//如果校验有异常
//            Map<String, String> errorMap = new HashMap<String, String>();//key 属性名称，value：报错信息
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            for(FieldError fieldError:fieldErrors){
//                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
//            }
//            model.addAttribute("errorMap",errorMap);//将错误信息返回给前台
            //使用spring的form标签库不在手动的组装返回给前台，前台时候Spring form标签库可以自动读取
            return "add";
        }
        System.out.println(user);
        return "show";
    }
}
