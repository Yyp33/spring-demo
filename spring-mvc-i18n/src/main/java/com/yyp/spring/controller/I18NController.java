package com.yyp.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class I18NController {

    /**
     * 如何进行国际化
     * 1：编写自愿文件前缀自定义后缀必须是相应的语言如中文就是xxx_zh_CN,英文是xxx_en_US
     *    注意同一组不同语言的资源文件前缀必须相同比如都是login
     * 2：配置文件配置并绑定资源文件
     *  <bean class="org.springframework.context.support.ResourceBundleMessageSource" id="messageSource">
     *     <property name="basename" value="login"></property>
     * <property name="defaultEncoding" value="utf-8"></property>
     *     </bean>
     *  3：页面使用jst格式化标签展示<fmt:message key="welcome"/> key为资源文件中的key
     *  注意使用jstl标签需要引入：jstl.jar 和standard.jar
     * @return
     */
    @PostMapping("/login")
    public String login(){
        return "success";
    }

    @GetMapping("/login")
    public String login1(){
        System.out.println("getLogin");
        return "login";
    }

    /**
     * 使用按钮手动切换语言版本
     * 1：自定义区域语言解析器
     * 2: 配置文件配置自定义区域语言解析器
     * <bean class="com.yyp.spring.resolver.MyLocaleResolver" id="localeResolver"></bean>
     *
     * 原理就是切换掉原有的request中的locale对象，进行传参自定义
     * @return
     */
    @GetMapping("/change")
    public String changeMessage(){
        return "login";
    }

    /**
     * 使用按钮手动切换语言版本
     * 1：使用springmvc提供的默认的区域语言解析器SessionLocaleResolver
     * 结合springmvc提供的拦截器进行切换语言LocaleChangeInterceptor，
     * 2：配置文件进行配置，测试需要注掉之前设置的自定义解析器
     *
     * 注意：
     * 1：语言参数名必须是locale
     * 2：国家与语言类别需要使用_分割
     * @return
     */
    @GetMapping("/change1")
    public String changeMessage1(@RequestParam(value = "locale",defaultValue = "zh_CN") String localeStr, Locale locale, HttpSession session){
       /*
       以下代码由springmvc提供的LocaleChangeInterceptor拦截器实现
       Locale l = null;
        if(localeStr!=null && ! "".equals(localeStr)){
            l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        }else{
            l = locale;
        }
        session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE",l);*/
        return "login";
    }
}
