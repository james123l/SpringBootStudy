package springstudy.beans.javaconfig;


import org.springframework.context.annotation.*;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;

@Configuration
//配置类注解 完全替代xml
@ComponentScan("springstudy.beans.javaconfig")
//扫描包下的组件
public class MyConfig {
    @Primary    //当这个类被需要装配的时候，这个James对象会被优先装配
    @Scope("prototype") //原型模式默认在ioc获取的时候创建
    //放在bean上 多实例
    @Bean
    //@Bean(initMethod = "init",destroyMethod = "destroy") 定义初始化和销毁方法，这里使用实现接口所以注解掉，需要类中有方法签名为这两个的方法，单实例是随着context创建销毁，多实例是只管创建不管销毁
    //返回组件名即为James 方法名
    public PersonDIWithConstructor James(){
        return new PersonDIWithConstructor();
    }
}
