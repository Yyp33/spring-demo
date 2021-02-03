import dao.UserDao;
import entity.Person;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class IOCTest {
    public static void main(String[] args) {
        System.out.println(111);
    }

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
        context = new ClassPathXmlApplicationContext("spring-ioc.xml");
    }

    /**
     * 测试基础的从spring容器中获取bean的三种方式
     */
    @Test
    public void test01(){
        //获取bean
        //1. 通过类来获取bean
//        UserService userService =  context.getBean(UserService.class);
        //2. 通过bean的id来获取bean
//        UserService userService1 = (UserService) context.getBean("userService");
        //3. 通过名字加上类名
//        UserService userService2 = context.getBean("userService", UserService.class);


    }

    //通过<alias>设置的别名获取 如：<alias name="userService" alias="userService2"></alias>
    //通过bean里的name也可以设置别名，别名直接可以使用空格，逗号，分号进行分割
    //如：<bean class="dao.impl.UserOracleDaoImpl" id="userOracleDao, userOracleDao1"></bean>
    @Test
    public void test02(){
        //spring配置的xml中使用别名<alias> 所以使用别名也能渠道bean
        UserService userService = context.getBean("userService2", UserService.class);
        userService.getUser();

        UserDao userDao = context.getBean("userOracleDao", UserDao.class);
        userDao.getUser();
        UserDao userDao1 = context.getBean("userOracleDao1", UserDao.class);
        userDao1.getUser();
    }

    /**
     * 测试基于set放的依赖注入
     */
    @Test
    public void test03(){
        User user  = context.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 测试基于构造函数的依赖注入
     */
    @Test
    public void test04(){
        User user  = context.getBean("user1",User.class);
        System.out.println(user);
    }

    /**
     * 复杂数据类型的依赖注入
     */
    @Test
    public void test05(){
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }


    /**
     * 使用自定义p命名空间的方式注入属性值
     */
    @Test
    public void test06(){
        Person person = context.getBean("person1", Person.class);
        System.out.println(person);
    }
}
