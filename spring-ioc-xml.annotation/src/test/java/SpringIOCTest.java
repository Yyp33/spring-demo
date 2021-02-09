import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyp.spring.Entity.User;
import com.yyp.spring.controller.UserController;

public class SpringIOCTest {
    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("Spring-ioc.xml");
    }

    /**
     * 测试类的属性使用@Value注解赋值
     * @Value("测试Value注解")
     */
    @Test
    public void test01(){
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
    /**
     * 测试类的属性使用@Value注解赋值
     * @Value("${mysql.username}") 读取属性文件中的值注入
     */
    @Test
    public void test02(){
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
    /**
     * 测试类的属性使用@Value注解赋值
     * 使用#{} 使用SPEL表达式"#{role.name}"
     *
     */
    @Test
    public void test03(){
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    /**
     * 测试类的属性使用@Value注解赋值
     * 3、使用#{} 使用SPEL表达式手动注入对象@Value("#{userServiceImpl}")
     */
    @Test
    public void test04(){
        UserController userController = context.getBean(UserController.class);
        userController.getUser();
    }

    /**
     * 类的属性自动注入，自动注入的属性必须是对象且存在于ioc容器中
     *  @Autowired 优先根据类型进行匹配，然后根据名称去匹配，
     *  如果出现多个类型相同且没有名称相同的就会报错解决方案：
     *  1、修改属性的名称改成bean1的名字：userServiceImpl
     *  2、修改bean的名字 @service("userService")
     *  3、使用@Qualifier("userServiceImpl")设置属性在容器中查找的名字
     *  4、设置@Primary设置其中一个bean为主要的自动注入bean
     *
     *  主要使用第二种方式
     */
    @Test
    public void test05(){
        UserController userController = context.getBean(UserController.class);
        userController.getUser();
    }
    /**
     * 类的属性自动注入，自动注入的属性必须是对象且存在于ioc容器中
     *  @Autowired 优先根据类型进行匹配，然后根据名称去匹配，
     *  如果出现多个类型相同且没有名称相同的就会报错解决方案：
     *  1、修改属性的名称改成bean1的名字：userServiceImpl
     *  2、修改bean的名字 @service("userService")
     *  3、使用@Qualifier("userServiceImpl")设置属性在容器中查找的名字
     *  4、设置@Primary设置其中一个bean为主要的自动注入bean
     *  5、使用泛型限定
     *
     *  测试泛型限定
     *
     *
     */
    @Test
    public void test06(){
        UserController userController = context.getBean(UserController.class);
        userController.getObject();
    }

    /**
     * 测试Autowired 可以写在构造方法上也可以写在方法上
     */
    @Test
    public void test07(){
        UserController userController = context.getBean(UserController.class);
        userController.getUser();
    }

    /**
     *autowire与resource区别：
     resource依赖jdk autowire依赖spring
     resource优先根据名字匹配
     autowire优先根据类型
     测试resource
     */
    @Test
    public void test08(){
        UserController userController = context.getBean(UserController.class);
        userController.getUser();
    }
}
