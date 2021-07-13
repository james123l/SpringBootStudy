package springstudy.beans.javaconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;

@Configuration
//配置类注解 完全替代xml
@ComponentScan("springstudy.beans.javaconfig")
//扫描包下的组件
public class MyConfig {
    @Bean
    //返回组件名即为James 方法名
    public PersonDIWithConstructor James(){
        return new PersonDIWithConstructor();
    }
}
