package com.yyp.spring.config;

import com.yyp.spring.Entity.Role;
import com.yyp.spring.Entity.User;
import com.yyp.spring.Import.MyImportBeanDefineRegister;
import com.yyp.spring.Import.MyImportSelector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 用户自定义一个spring配置类
 * 之前是使用xml方式启动spring上下文
 * 相当于以前的xml文件
 */
@Configuration//注册为配置类
@ComponentScan(basePackages = "com.yyp")//扫描的注解包
@PropertySource("db.properties")//读取属性文件
/**
 * @Import
 * 1、引入其他javaConfig配置类
 * @Import({IOCJavaConfigSecond.class})
 * 2、引入其他实体类注册为Bean
 * @Import(Role.class)
 * 3、自定义Import需要实现ImportSelector接口选择器可一次性注入多个bean
 * @Import(MyImportSelector.class)
 * 4、自定义beanDefine即定义bean，实现ImportBeanDefinitionRegistrar接口
 *
 */
@Import(MyImportBeanDefineRegister.class)
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
     *
     * 怎么注入或者依赖其他的bean，只需要在方法上面写上需要的参数就可以，不需要@Autowire
     */
    @Bean
    public DruidDataSource dataSource(User user){
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
        System.out.println(user);
        return dataSource;
    }
}
