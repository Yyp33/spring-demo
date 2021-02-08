import entity.Person;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class IOCHTest {

    ApplicationContext context;
    //使用before注解之后，所有运行带@test注解的方法都会先执行带有before注解的方法
    @Before
    public void beforeMethod(){
        //加载spring容器
        //ApplicationContext spring容器的顶层接口
        //ClassPathXmlApplicationContext 根据项目路径读取配置文件
        //FileSystemXmlApplicationContext 根据磁盘路径的xml来实例化Spring容器
        //AnnotationConfigApplicationContext 根据注解实例化Spring容器
        //在容器实例化的时候，就会加载所有的bean
        context = new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    /**
     * 展示bean的加载顺序
     */
    @Test
    public void test01(){
        System.out.println("展示bean的加载顺序");
    }

    /**
     * 测试懒加载
     */
    @Test
    public void test02(){
        System.out.println("spring容器加载完成");
        User user2 = context.getBean("user2", User.class);
    }

    /**
     * 测试bean的作用域
     * singleton 单例
     * prototype 多例
     * request 一个bean的生命周期为一个http请求
     * session bean的生命周期为session会话
     * application 生命周期为web的servletContext的生命周期即一个应用类似与singleton request<session<application
     * websocket 长连接
     */
    @Test
    public void test03(){
        Person person2 = context.getBean("person2", Person.class);
        Person person21 = context.getBean("person2", Person.class);
        Person person3 = context.getBean("person3", Person.class);
        Person person31 = context.getBean("person3", Person.class);
    }

    /**
     * 不适用默认的无参构造方法创建bean
     * 使用自定义的静态方法创建bean
     */
    @Test
    public void test04(){
        Person person4 = context.getBean("person4", Person.class);
        System.out.println(person4);
    }

    /**
     * 不适用默认的无参构造方法创建bean
     * 使用自定义的工厂对象创建bean，非静态方法
     */
    @Test
    public void test05(){
        Person person5 = context.getBean("person5", Person.class);
        System.out.println(person5);
    }

    /**
     * xml配置文件方式下的自动注入
     * autowire属性：
     * byType 会在ioc容器中查找同样类型的对象注入,比如Person中需要Wife 但是ioc中如果有多个Wife就会报错，因为类型都是wife不知道要注入哪个
     * byName 会在ioc容器中查找id与对象中名称一致的bean进行注入,精准度比较高
     * constructor 通过类的构造函数进行注入：优先根据名字进行匹配，如果通过名称没有匹配到会根据类型就行匹配
     * ，但是构造函数中传入的对象，必须都存在与IOC容器中，如Person(Wife wife)可以
     * ，但是Person(Wife wife, String name)不可以，因为没有id是name的bean
     * 注入时如果通过byname没有匹配到，会通过类型匹配，如果有多个类型，对象会为null，不会报错
     * default
     * no
     *
     * 自动注入对象时尤其时通过byType容易出现多个类型，可在其中一个bean中加入primary=”true“ 意思时以这个bean为主
     */
    /**
     * 验证byType
     */
    @Test
    public void test06(){
        Person person6 = context.getBean("person6", Person.class);
        System.out.println(person6);
    }
    /**
     * 验证byName
     */
    @Test
    public void test07(){
        Person person6 = context.getBean("person7", Person.class);
        System.out.println(person6);
    }

    /**
     * 验证constructor
     */
    @Test
    public void test08(){
        Person person6 = context.getBean("person8", Person.class);
        System.out.println(person6);
    }

    /**
     * 验证ByType有多个类型时
     * 会有两种解决方案：1：加入primary=true即可，想要用的bean中加入
     *               2：其他bean中加入autowire-candidate=false不参与自动注入
     * 验证primary
     */
    @Test
    public void test09(){
        Person person6 = context.getBean("person9", Person.class);
        System.out.println(person6);
    }

    /**
     * 验证bean的生命周期
     * 1.使用接口方式
     *  1.1   初始化方法： 实现接口： InitializingBean  重写afterPropertiesSet方法   初始化会自动调用的方法
     *  1.2   销毁的方法： 实现接口： DisposableBean  重写destroy 方法   销毁的时候自动调用方法
     * 2.使用xml配置的方式
     */
    @Test
    public void test10(){
        Person person6 = context.getBean("person10", Person.class);
        System.out.println(person6);
    }

    /**
     * 验证bean的生命周期
     * 2.使用xml配置的方式
     */
    @Test
    public void test11(){
        Person person6 = context.getBean("person11", Person.class);
        System.out.println(person6);
    }

    /**
     * 测试创建第三方bean
     */
    @Test
    public void test12(){
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }

    /**
     * 测试创建第三方bean
     * 并引入属性文件（.properties）
     */
    @Test
    public void test13(){
        DataSource dataSource = context.getBean("dataSource1", DataSource.class);
        System.out.println(dataSource);
    }

    /**
     * 测试Spel表达式
     */
    @Test
    public void test14(){
        Person person14 = context.getBean("person14", Person.class);
        System.out.println(person14);
    }
}
