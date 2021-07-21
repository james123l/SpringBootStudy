package springbootdemo.demo.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import springbootdemo.demo.bean.Car;
import springbootdemo.demo.bean.Pet;
import springbootdemo.demo.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springbootdemo.demo.environment.WindowsCondition;

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
public class MyConfig implements WebMvcConfigurer {//MyConfig类本身也是组件

    /**
     * bean生成方法
     */
    /*@Bean给容器中添加组件
    方法名User=组件名（id），返回类型User就是组件类型。返回的对象就是组件保存在容器中的对象，不论获取多少次 ，该对象都是单例
    如果想给这个对象起名 可以@Bean(“James”)
     */
    @Bean
    //仅仅当windowsCondition返回true的情况下 才会向ioc容器添加组件
    @Conditional({WindowsCondition.class})
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

    /**
     * mvc restful 这个函数会导致溢出
     */
/*    @Bean
    //使rest风格的_METHOD可以自定义
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        //通过设置这个参数 使得客户端发送的post请求隐藏的表单name可以不是_METHOD而是_m
        //因为设置问题 客户端表单的name属性值不论是大写还是小写 都会在服务端变成大写
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter();
    }*/


    //开启矩阵变量配置：springboot默认关闭。 需要当前类实现webmvcconfigurer
    //手动配置
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
    //容器中直接放入bean
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
}
