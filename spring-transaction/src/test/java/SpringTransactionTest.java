import com.alibaba.druid.pool.DruidDataSource;
import com.yyp.spring.entity.User;
import com.yyp.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringTransactionTest {

    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("Spring.xml");
    }

    /**
     * jdbcTemplate配置初始使用 查询单值
     */
    @Test
    public void  test01(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

        Long aLong = bean.queryForObject("select count(*) from user ", Long.class);
        System.out.println(aLong);
    }

    /**
     * jdbcTemplate配置初始使用 查询实体类
     */
    @Test
    public void  test02(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

        //实体类属性名称与表的字段名称一致才可以，可以使用BeanPropertyRowMapper
        User user = bean.queryForObject("select * from user where id = 1 "
                , new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);

        //实体类字段名称与表的名称不一致
        User user1 = bean.queryForObject("select * from user where id = 1 "
                , new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user2 = new User();
                        user2.setId(resultSet.getInt("id"));
                        user2.setRealName(resultSet.getString("realname"));
                        return user2;
                    }
                });
        System.out.println(user1);
    }

    /**
     * jdbcTemplate配置初始使用 查询实体类List
     */
    @Test
    public void  test03(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

        //实体类属性名称与表的字段名称一致才可以，可以使用BeanPropertyRowMapper
        List<User> user = bean.query("select * from user "
                , new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);

        //实体类字段名称与表的名称不一致
        List<User> user1 = bean.query("select * from user "
                , new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user2 = new User();
                        user2.setId(resultSet.getInt("id"));
                        user2.setRealName(resultSet.getString("realname"));
                        return user2;
                    }
                });
        System.out.println(user1);
    }

    /**
     * jdbcTemplate配置初始使用 新增
     */
    @Test
    public void  test04(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

        //增加
         int  res = bean.update("insert  into user(realname,cardno, balance) values(?,?,?)"
         , "zhaoliu", "122222",400);
        System.out.println(res);

    }
    /**
     * jdbcTemplate配置初始使用 更新
     */
    @Test
    public void  test05(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);

        //增加
        int  res = bean.update("update user set realname='ceshi' where id = ? "
                , 5);
        System.out.println(res);

    }
    /**
     * jdbcTemplate配置初始使用 删除
     */
    @Test
    public void  test06(){
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);
        //增加
        int  res = bean.update("delete from user  where id = ? "
                , 4);
        System.out.println(res);
    }

    /**
     * namedParameterJdbcTemplate配置初始使用 删除
     */
    @Test
    public void  test07(){
        NamedParameterJdbcTemplate bean = context.getBean(NamedParameterJdbcTemplate.class);
        //增加
        Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        int  res = bean.update("delete from user where id= :id",
                map);
        System.out.println(res);
    }

    /**
     * 通过业务逻辑查询
     */
    @Test
    public void  test08(){
        UserService bean = context.getBean(UserService.class);

        System.out.println(bean.getUser());
    }

    /**
     * 验证事务原子性，在add()时出现异常，应该会出现回滚，数据库值不变
     */
    @Test
    public void  test09(){
        UserService bean = context.getBean(UserService.class);
        bean.trans();
    }

    /**
     * 验证事务嵌套，默认外部有事务就会融合进外部事物
     * 默认传播行为required
     * 首先以为直接service层调用trans，外部没有事务，在required传播行为下也会开启一个事务
     * trans，add，sub 都加入事务，如果不是融合的add报错不会影响sub事务
     * 如果融合如果add报错 sub也会回滚
     *
     */
    @Test
    public void  test10(){
        UserService bean = context.getBean(UserService.class);
        bean.trans();
    }

    /**
     * 验证事务嵌套
     * 传播行为supports
     * 直接service调用getUser 外部没有事务，不会开始事务
     * 如果getUser在trans中使用就会融合到trans的事务中
     * 当出现异常sub 以及add都会回滚
     */
    @Test
    public void  test11(){
        UserService bean = context.getBean(UserService.class);
        bean.trans();
    }
    /**
     * 验证事务嵌套
     * 传播行为required_new
     * 外部存在事务会挂起外部事务新建一个新的事务执行相应的方法，两个事务互不影响
     */
    @Test
    public void  test12(){
        UserService bean = context.getBean(UserService.class);
        bean.trans();
    }
    /**
     * 验证timeout 超时
     */
    @Test
    public void  test13(){
        UserService bean = context.getBean(UserService.class);
        bean.trans();
    }
}
