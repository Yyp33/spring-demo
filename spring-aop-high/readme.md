Spring AOP详细应用
一、注解方式实现AOP
   1、xml文件中开启注解
   <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
   2、切面类增加注解@Aspect 并注入到spring容器中@Component
   3、方法上加入通知类型
       @Before 前置通知
       @After 后置通知
       @AfterThrowing 后置异常通知
       @AfterReturning 后置返回通知
       @Around:环绕：环绕通知
   4、通知类型中加入切点表达式，例如
   @Before("execution(* com.yyp.spring.service..*.*(..))")
二、切点表达式
    1、切点标识符
    execution 用于标记切面切点表达式，力度比较细致：可以标记到类或者方法
    within：力度比较粗只能匹配到类级别
        within(包名.类名)因为只能匹配到类，所以不需要访问修饰符，以及返回值类型
        可以使用*以及.. 开匹配任意类名以及子孙包
        within(com.yyp.spring.service.impl.RoleServiceImpl)
        within(com.yyp.spring.service.impl.*)impl包下任意类名，不包含子孙包
        within(com.yyp.spring.service..*)service包及其子孙包下任意类
    @annotation:限制匹配连接点（在Spring AOP中执行的方法具有给定的注解）。用于匹配注解的
    其中需要写
    2、切点表达式语法
    （1）访问修饰符，可以不写，指的方法的访问修饰符
    （2）返回值类型，必须写，* 可以代表任何返回值类型，如果要写：返回值类型是jdk自带的可以直接写类名
        如果是自定义的类需要写全限定名
    （3）包名：*代表任意包名但是只能匹配一级，..代表子孙包
        cn.*   == cn.yyp   == cn.任意名字   但是只能匹配一级    比如 cn.yyp.service就无法匹配
        如果要cn.yyp.*    ==>cn.yyp.service  , cn.yyp.*      ==>cn.yyp.service.impl就无法匹配
         cn.yyp..*      ==>cn.yyp.service.impl   可以匹配   
    （4）类名：*可以代表任意类名
    （5）方法名：*可以代表任意方法名
        set* 可以匹配到：setA, setBB
    （6）方法参数：如果是jdk自带类型可以不用写完整限定名，如果是自定义类型需要写上完整限定名。..可以代表任意方法参数
 三、表达式联合使用
    && 并且
    || 或者
    ！ 非
    @annotation(jdk.nashorn.internal.runtime.logging.Logger)&&execution(* com.yyp.spring.service..*.*(..)
 四、通知的执行顺序
    正常：前置-》后置-》后置返回
    异常：前置-》后置-》后置异常
    加入环绕通知
    环绕前置-》前置-》方法-》环绕后置-》环绕后置返回-》后置-》后置返回
 五、通知方法中加入参数获取方法的名称，参数等等
  1、@Before通知：方法中加入JoinPoint
    @Before("@annotation(jdk.nashorn.internal.runtime.logging.Logger)&&execution(* com.yyp.spring.service..*.*(..))")
    public static void start(JoinPoint joinPoint)
    可以通过
    String methodName = joinPoint.getSignature().getName();//方法名
    Object[] objects = joinPoint.getArgs();//方法参数
  2、@AfterReturning可以获取返回值，需要returning指定返回值参数名称
    @AfterReturning(value = "execution(* com.yyp.spring.service..*.*(..))"
              ,returning = "result" )
      public static void end(JoinPoint joinPoint, Object result){
          System.out.println("方法结束,返回结果"+result);
      }
  3、@AfterThrowing 可以获取到异常信息，需要throwing指定异常信息参数名称
    @AfterThrowing(value = "execution(* com.yyp.spring.service..*.*(..))"
              , throwing="e")
      public static void logException(JoinPoint joinPoint, Exception e)  
  4、获取注解信息
    注意如果方法中需要注解信息时：@annotation中不能写注解的全限定名而是对应的参数名称
     @After(value = "execution(* com.yyp.spring.service..*.*(..))&&@annotation(logger)")
     public static void stop(JoinPoint joinPoint, Logger logger){
六、切点表达式抽离：
    将切点表达式用@Pointcu注解写到一个空的方法上，然后其他方法可以进行引用，方便后期维护
    @Pointcut("execution(* com.yyp.spring.service..*.*(..))")
        public void pointcut(){}
    @Before("pointcut()")//切点表达式抽离
七、XML配置方式实现AOP，但是基本都使用注解方式更加方便
    