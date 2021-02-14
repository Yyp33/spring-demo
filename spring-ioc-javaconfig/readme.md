javaConfig方式实现bean的注册，属性的注入，测试类SpringIOCTest
一、自定义配置类IOCJavaConfig
   用户自定义一个spring配置类,之前是使用xml方式启动spring上下文
   ,相当于以前的xml文件。
   配置方式：使用@Configuration注解标注为配置类
            @ComponentScan(basePackages = "com.yyp")用于扫描注解
   1、Bean注解，可以使用在@Configuration或者@Component注解的类中
   @Bean注解，是一个方法级别的注解，可以将方法返回的对象注入到spring容器中
   ，并且bean的id就是方法的名称。可以使用name属性设置定义的id
   与@Controller或者@Service不同的是他是自己new然后注入容器中
   而controller是由spring容器实例化，这样的好处是有些累我们可以
   干预他的实例化过程，做一些符合自己业务的优化
   2、@PropertySource("db.properties")可以读取属性文件，并结合@Value("${userName}") 进行获取值