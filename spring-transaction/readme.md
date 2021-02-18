Spring 声明式事务相关模块
一、事务的四个特性ACID
    1、原子性A
        事务内所有操作要么全部成功，要么全部不成功
    2、一致性C
        事务前后的数据要保证数据的一致性
        在一组的查询业务下    必须要保证前后关联数据的一致性 
        比如转账业务A减少100 B增加100 A+B的总金额是不变的
    3、隔离性I
        两个事务直接不相互影响
    4、持久性D
        数据库中的数据持久性存储，即使断电也可以存储
 二、事务实现的两种方式
    1、编程式事务，即事务的开启，提交，回滚显示的写在代码中
    2：声明式事务，事务通过注解或者配置文件的方式定义，从业务代码中剥离出来，实现解耦，通过AOP的方式
        横向切面到切点方法上
 三、基于注解方式实现声明式事务
    1、配置文件配置事务管理器
    <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="dataSourceTransactionManager">
            <property name="dataSource" ref="dataSource"></property>
    </bean>
    2、配置文件开启基于注解的事务驱动
    <tx:annotation-driven transaction-manager="dataSourceTransactionManager"></tx:annotation-driven>
    3、在相应的方法上或者类上加入@Transaction注解，相应的类中的方法就会加入事务管理
 四、@Transaction注解属性
    1、isolation 隔离级别
        （1）脏读：读取到其他事务未提交的修改
            解决方式：@Transactional(isolation = Isolation.READ_COMMITTED)
                   读已提交：READ COMMITTED
        （2）不可重复度：两次读取同一条记录结果不同。
            mysql的默认隔离级别，通过mvcc机制实现，undo日志以及read-view
            解决方式：@Transactional(isolation = Isolation.REPEATABLE_READ)
                    可重复读：REPEATABLE_READ（行锁）
        （3）幻读：两次读取的数据条目不同
         不可重复度与幻的区别在于不可重复度注重更新、删除，幻读着于新增
         解决方式：@Transactional(isolation = Isolation.SERIALIZABLE)
                             串读：SERIALIZABLE（表锁）
    2、propagation 事务的传播行为即事务嵌套
        1、REQUIRED默认    
            外部不存在事务开启新的事务   外部存在事务融入外部事务    
            侧重于增、删、改的方法，单独调用时也要加上事务管理。
        2、SUPPORTS       
            外部不存在事务不开启事务     外部存在事务融入外部事务    
            侧重查询方法，单独调用查询方法不用开启事务
        3、REQUIRES_NEW   
            外部不存在事务开启新的事务    外部存在事务外部事务挂起，开启一个新的事务  
            用于记录阶段性日志, 注意此事务传播行为标记的方法与父方法不能同在一个类中
        如果当前业务方法是一组 增、改、删  可以这样设置事务
        @Transactional
        如果当前业务方法是一组 查询  可以这样设置事务
        @Transactionl(readOnly=true)
        如果当前业务方法是单个 查询  可以这样设置事务
        @Transactionl(propagation=propagation.SUPPORTS ,readOnly=true)
    3、timeout 超时（秒）
    4、readonly 只读事务 
       