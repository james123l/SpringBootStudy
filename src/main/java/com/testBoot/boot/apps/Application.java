package com.testBoot.boot.apps;

import com.testBoot.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication //springboot的启动类
@EnableAutoConfiguration
@ComponentScan("com.testBoot.boot")
public class Application {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

       //查看容器内的组件
        String[] names=run.getBeanDefinitionNames();
        for (String str:names) {
            System.out.println(str);
        }

        //从容器中获取组件
       // MyConfig bean = run.getBean(MyConfig.class);
        User james = run.getBean("James",User.class);
        System.out.println(james);


    }
}