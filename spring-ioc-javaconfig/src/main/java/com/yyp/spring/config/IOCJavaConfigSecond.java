package com.yyp.spring.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * 第二个javaConfig配置类
 * IOCJavaConfig配置类可以通过@Import()注解引入
 * 这个配置类
 */
@ComponentScan("com.second")
public class IOCJavaConfigSecond {
}
