import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("Spring.xml");
    }

    @Test
    public void  test01(){

    }
}
