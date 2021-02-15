javaConfig方式实现bean的注册，属性的注入，测试类SpringIOCTest
一、自定义配置类IOCJavaConfig
   用户自定义一个spring配置类,之前是使用xml方式启动spring上下文
   ,相当于以前的xml文件。
   配置方式：使用@Configuration注解标注为配置类
            @ComponentScan(basePackages = "com.yyp")用于扫描注解
二、@Bean
   是可以使用在@Configuration或者@Component注解的类中一个注解
   1、@Bean注解，是一个方法级别的注解，可以将方法返回的对象注入到spring容器中
    ，并且bean的id就是方法的名称。可以使用name属性设置定义的id
    与@Controller或者@Service不同的是他是自己new然后注入容器中
    而controller是由spring容器实例化，这样的好处是有些累我们可以
    干预他的实例化过程，做一些符合自己业务的优化
   2、怎么注入或者依赖其他的bean，只需要在方法上面写上需要的参数就可以，不需要@Autowire
三、@PropertySource("db.properties")
    可以读取属性文件，并结合@Value("${userName}") 进行获取值
四、@Import
  1、引入其他javaConfig配置类
    @Import({IOCJavaConfigSecond.class})
  2、引入其他实体类注册为Bean
    @Import(Role.class)
  3、自定义Import需要实现ImportSelector接口选择器可一次性注入多个bean
    @Import(MyImportSelector.class)
  4、自定义beanDefine即定义bean，实现ImportBeanDefinitionRegistrar接口
    @Import(MyImportBeanDefineRegister.class)
    
五、总结将一个类注入到IOC中
  1、xml <bean>
  2、@Component、@Controller、@Service、@Repository
  3、@Bean
  4、@Import