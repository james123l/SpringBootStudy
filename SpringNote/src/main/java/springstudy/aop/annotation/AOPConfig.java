package springstudy.aop.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/*
* 使用config可以完全不用xml
* */
@Configuration
@ComponentScan("springstudy")
@EnableAspectJAutoProxy(proxyTargetClass = true)    //参数默认是false 可以代替xml文件中开启aspectj
public class AOPConfig {
}
