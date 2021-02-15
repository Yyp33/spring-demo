import com.second.config.TestSecondConfig;
import com.yyp.spring.Entity.Person;
import com.yyp.spring.Entity.Role;
import com.yyp.spring.Entity.Wife;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.yyp.spring.config.IOCJavaConfig;
import com.yyp.spring.controller.UserController;

public class SpringIOCTest {
    ApplicationContext context;

    @Before
    public void before(){
       context = new AnnotationConfigApplicationContext(IOCJavaConfig.class);
    }
    /**
     * 测试使用自定义配置类，启动spring上下文，
     * 注册springioc容器
     */
    @Test
    public void test01(){

        UserController contextBean = context.getBean(UserController.class);
        contextBean.getUser();
    }
    /**
     * 测试使用@Bean注解，配置方法返回对象注入spring容器
     * 是一个方法级别的注解，可以将方法返回的对象注入到spring容器中
     * 并且bean的id就是方法的名称，可以使用name属性设置定义的id
     * 与@Controller或者@Service不同的是他是自己new然后注入容器中
     * 而controller是由spring容器实例化，这样的好处是有些累我们可以
     * 干预他的实例化过程，做一些符合自己业务的优化
     */
    @Test
    public void test02(){

        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean);
    }

    /**
     * 使用@PropertySource("db.properties")读取属性文件
     */
    @Test
    public void test03(){

        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean);
    }
    /**
     *测试通过@Import({IOCJavaConfigSecond.class})//引入其他javaConfig配置类
     */
    @Test
    public void test04(){

        TestSecondConfig bean = context.getBean(TestSecondConfig.class);
        System.out.println(bean);
    }

    /**
     *测试通过引入其他实体类注册为Bean
     * @Import(Role.class)
     */
    @Test
    public void test05(){

        Role bean = context.getBean(Role.class);
        System.out.println(bean);
    }

    /**
     *测试@Import(MyImportSelector.class)
     * 自定义Import需要实现ImportSelector接口选择器可一次性注入多个bean
     */
    @Test
    public void test06(){

        Person bean1 = context.getBean(Person.class);
        Wife bean = context.getBean(Wife.class);
        System.out.println(bean);
        System.out.println(bean1);
    }

    /**
     *测试@Import(MyImportBeanDefineRegister.class)
     * 自定义beanDefine即定义bean，实现ImportBeanDefinitionRegistrar接口
     */
    @Test
    public void test07(){

        Person bean1 = context.getBean(Person.class);
        System.out.println(bean1);
    }
}
