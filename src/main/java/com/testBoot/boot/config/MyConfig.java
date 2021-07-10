package com.testBoot.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.testBoot.boot.bean.Car;
import com.testBoot.boot.bean.Pet;
import com.testBoot.boot.bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({User.class, DBHelper.class})  //需要标记在组件上
/*
可以调用无参构造器，给容器自动创建这个类型的组件。
与@Bean导入的User是不同的组件，@Import导入的组件名默认是com.testBoot.boot.bean.User
 */
@Configuration
/*告诉springboot这是个配置类,配置类的@Bean标注在方法是给容器注册组件，默认是单实例
MyConfig类本身也是组件
与springboot1不同 2具有注解@proxyBeanMethods -代理bean的方法 默认是true
----  如果@proxyBeanMethods(true) 适用于full全配置 main的geibean获取到的是代理对象，如果调用MyConfig的方法，即创造User，springboot会检查是否有User在容器中以保持单实例
----  如果@proxyBeanMethods(false) lite 轻量级  main的geibean获取到的是代理对象，如果调用MyConfig的方法，即创造User，会得到不同的实例
解决组件依赖问题
 */
@ConditionalOnMissingBean(name = "Tom") //没有Tom组件才会执行内部组件
/*
@ConditionalOnBean(name = "Tom")  有Tom组件的时候， 类内部的组件才可以生效
 */
@EnableConfigurationProperties(Car.class)   //配置绑定方法二
/*
1.开启car配置绑定功能
2.把car这个组件自动注册到容器中
 */
public class MyConfig {

    /*给容器中添加组件
    方法名User=组件名（id）
    返回类型User就是组件类型
    返回的对象就是组件保存在容器中的对象，不论获取多少次 ，该对象都是单例
    如果想给这个对象起名 可以@Bean(“James”)
     */
    @Bean
    public Pet Tom(){
        return new Pet("Tom");
    }


    @Bean
    /*
    conditional注解限制条件
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
