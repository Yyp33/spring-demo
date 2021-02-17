import com.yyp.spring.Entity.Role;
import com.yyp.spring.service.RoleService;
import com.yyp.spring.service.UserService;
import com.yyp.spring.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("SpringAOP.xml");
    }

    /**
     * 测试execution 可以匹配到方法级别
     * execution(* com.yyp.spring.service..*.*(..))
     */
    @Test
    public void test01(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(1);

    }

    /**
     * 测试within 只能匹配到类级别
     * within(com.yyp.spring.service.impl.RoleServiceImpl)
     */
    @Test
    public void test02(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(1);

    }
    /**
     * 测试within 只能匹配到类级别
     * @annotation(jdk.nashorn.internal.runtime.logging.Logger)
     */
    @Test
    public void test03(){
        RoleService bean = context.getBean(RoleService.class);
        bean.delete(1);

    }

    /**
     * 测试切点表达式合并&&、||、!
     * @annotation(jdk.nashorn.internal.runtime.logging.Logger)&&execution(* com.yyp.spring.service..*.*(..)
     */
    @Test
    public void test04(){
        RoleService bean = context.getBean(RoleService.class);
        bean.delete(1);

    }

    /**
     * 测试通知方法中加入参数获取方法的名称以及参数
     */
    @Test
    public void test05(){
        RoleService bean = context.getBean(RoleService.class);
        bean.delete(1);
    }

    /**
     * 测试通知方法中加入参数获取方法的名称以及参数，以及返回值
     */
    @Test
    public void test06(){
        RoleService bean = context.getBean(RoleService.class);
        bean.delete(1);
    }
    /**
     * 测试通知方法中加入参数获取方法的名称以及参数，以及异常信息
     */
    @Test
    public void test07(){
        RoleService bean = context.getBean(RoleService.class);
        bean.add(null);
    }

    /**
     * 测试获取注解信息
     */
    @Test
    public void test08(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(null);
    }

    /**
     * 测试@Pointcut 切点表达式抽离
     */
    @Test
    public void test09(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(null);
    }
    /**
     * 测试@Around环绕通知
     */
    @Test
    public void test10(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(null);
    }

    /**
     * 测试XML方式配置
     */
    @Test
    public void test11(){
        RoleService bean = context.getBean(RoleService.class);
        bean.get(null);
    }
}
