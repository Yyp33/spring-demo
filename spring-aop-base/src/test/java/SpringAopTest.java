import com.yyp.spring.dynmic.Calculator;
import com.yyp.spring.dynmic.impl.CalculatorImpl;
import com.yyp.spring.dynmic.impl.JDBCProxyUtils;
import com.yyp.spring.service.RoleService;
import com.yyp.spring.statical.imple.GamePlayer;
import com.yyp.spring.statical.imple.GamePlayerProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.rowset.JdbcRowSet;

public class SpringAopTest {

    /**
     * 测试静态代理
     */
    @Test
    public void test01(){
        GamePlayer gamePlayer = new GamePlayer("菜鸟");
        gamePlayer.start();
        gamePlayer.play();

        GamePlayerProxy proxy = new GamePlayerProxy("代练", gamePlayer);
        proxy.start();
        proxy.play();
    }

    /**
     * 测试动态代理
     */
    @Test
    public void test02(){
        CalculatorImpl calculator = new CalculatorImpl();
        Calculator calculatorProxy = (Calculator) JDBCProxyUtils.getProxy(calculator);
        calculatorProxy.add(1,2);
        calculatorProxy.multi(2,3);
    }

    /**
     * 测试AOP简单使用
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springAOP.xml");
        RoleService bean = context.getBean(RoleService.class);
        bean.add(null);
        bean.get(1);

    }



}
