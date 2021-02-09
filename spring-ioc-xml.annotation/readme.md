一、怎么将一个类注册为bean
        1、配置扫描包 <context:component-scan >
            <context:component-scan base-package="com.yyp" use-default-filters="true">
                <!--<context:exclude-filter type="aspectj" expression="org.springframework.stereotype.Controller"></context:exclude-filter>-->
                <!--<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:include-filter>-->
            </context:component-scan>
            exclude-filter 用于设置可以排除的不用扫描的类
            include-filter 用于设置需要各位扫描的类
            类型：
                annotation 默认 根据注解的全类名设置排除/包含
                assignable     根据类的全限定名设置排除/包含
                aspectj        根据切面表达式进行设置
                regex          根据正则表达式进行设置
                custom   可以实现org.example.MyTypeFilter 接口的实现类自定义实现
            use-default-filters 默认扫描所有的注解类
        2、在对应的类上边增加相应的注解,使用上边的注解会自动将首字母小写并设置为bean的名字即id
二、属性赋值
    1、直接在类的属性上增加@Value("")注解即可，详情见测试类SpringIOCTest：test01()、test02()、test03()三种方式;
    2、类的属性自动注入，自动注入的属性必须是对象且存在于ioc容器中
           *  @Autowired 优先根据类型进行匹配，然后根据名称去匹配，
           *  如果出现多个类型相同且没有名称相同的就会报错解决方案：
           *  1、修改属性的名称改成bean1的名字：userServiceImpl
           *  2、修改bean的名字 @service("userService")
           *  3、使用@Qualifier("userServiceImpl")设置属性在容器中查找的名字
           *  4、设置@Primary设置其中一个bean为主要的自动注入bean
              5、使用泛型限制
            自动注入可以写在方法上也可以写在构造器上
    3、autowire与resource区别：
        resource依赖jdk autowire依赖spring
        resource优先根据名字匹配
        autowire优先根据类型
三、其他注解
    @DependsOn("user) 通过控制依赖来控制加载顺序
    @Lazy 懒加载
    @Scope 作用域默认单例，其他类型可以查看xml高级模块中的可用属性值
    @PostConstruct 注解初始化方法
    @PreDestroy 销毁方法  
            