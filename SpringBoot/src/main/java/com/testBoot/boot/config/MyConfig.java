package com.testBoot.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.testBoot.boot.bean.Car;
import com.testBoot.boot.bean.Pet;
import com.testBoot.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import({User.class, DBHelper.class})  //参数是class数组 需要标记在组件上，可以根据其无参构造器创建对象作为组件放在容器中，与@Bean导入的User是不同的组件，@Import导入的组件名字默认是com.testBoot.boot.bean.User，即全类名
@ImportResource()   //参数是一个数组，数组内是（classpath：xml文件全类名），用于导入xml文件
@Configuration
/*告诉springboot这是个配置类,配置类的@Bean标注在方法上是给容器注册组件，默认是单实例
proxyBeanMethods -代理bean的方法 默认是true： 解决了组件依赖问题： 设置为true，james对象内部的组件tom就是全局唯一的pet tom组件，即注册james的时候，会先检查容器中是否有tom，没有则建造，有则调用
----  @Configuration(proxyBeanMethods(true))  full全配置 main的getbean获取到的是代理对象，如果调用MyConfig的方法，即创造User，springboot会检查是否有User在容器中以保持单实例
----  @Configuration(proxyBeanMethods(false)) lite 轻量级  main的getbean获取到的是代理对象，如果调用MyConfig的方法，即创造User，会得到不同的实例
 */
@ConditionalOnMissingBean(name = "Tom") //没有Tom组件才会执行MyConfig的内部组件
/*
@ConditionalOnBean(name = "Tom")  有Tom组件的时候， MyConfig的内部的组件才可以生效
 */
@EnableConfigurationProperties(Car.class)   //配置绑定方法二，1.开启car配置绑定功能。2.把car这个组件自动注册到容器中
public class MyConfig {//MyConfig类本身也是组件

    /*@Bean给容器中添加组件
    方法名User=组件名（id），返回类型User就是组件类型。返回的对象就是组件保存在容器中的对象，不论获取多少次 ，该对象都是单例
    如果想给这个对象起名 可以@Bean(“James”)
     */
    @Bean
    public Pet Tom(){
        return new Pet("Tom");
    }


    @Bean
    /*conditionalOnBean：注解限制条件
    有Tom组件的时候才开始注册James组件
     */
    @ConditionalOnBean(name = "Tom")
    public User James(){
        User james = new User("James", 27);
        //因为proxyBeanMethod(true) 所以此时写法正确，组件James依赖Tom
        james.setPet(Tom());
        return james;
    }
}
