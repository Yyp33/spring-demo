一、什么事AOP
    AOP是一种编程思想，其主要作用是在不改变原有代码的基础上，增加一些公共的非主要业务
    逻辑的功能。
二、代理
    AOP底层是使用代理思想。
    代理的两种类型：
    1、静态代理
        为每一个需要被代理的类都要自定义一个代理类，适合少量特殊的代理，若是需要被代理的类
        比较多，则工作比较繁重
    2、动态代理
        (1)JDBC动态代理：被代理的类需要实现接口，对接口实现代理
        (2)CGLIB动态代理：不需要接口
    Spring Aop是jdbc与cglib的结合，即AOP会判断当前需要代理的类是否实现了接口来判断是使用
    jdbc方式还是cglib方式动态创建代理类
三、AOP简单使用，案例类：LogUtil
    1、配置文件开启AOP功能
        <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
    2、切面类上增加@Aspect注解并且加入到spring容器@Component
    3、配置通知，将注解配置到相应的方法上
        @Before 前置通知
        @After 后置通知
        @AfterThrowing 后置异常通知
        @AfterReturning 后置返回通知