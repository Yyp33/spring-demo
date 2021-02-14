package com.yyp.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 用户自定义一个spring配置类
 * 之前是使用xml方式启动spring上下文
 * 相当于以前的xml文件
 */
@Configuration
@ComponentScan(basePackages = "com.yyp")
@PropertySource("db.properties")
public class IOCJavaConfig {

    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String passWord;

    @Value("${url}")
    private String url;

    @Value("${driveClassName}")
    private String driveClass;

    /**
     * 配置第三方bean
     * 使用@Bean注解，是一个方法级别的注解，可以将方法返回的对象注入到spring容器中
     * 可以使用name属性设置定义的id
     * 与@Controller或者@Service不同的是他是自己new然后注入容器中
     * 而controller是由spring容器实例化，这样的好处是有些累我们可以
     * 干预他的实例化过程，做一些符合自己业务的优化
     */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setName("root");
//        dataSource.setPassword("123456");
//        dataSource.setUrl("jdbc:mysql:localhost:3306/test");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //使用读取属性文件方式
        dataSource.setName(userName);
        dataSource.setPassword(passWord);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driveClass);
        return dataSource;
    }
}
