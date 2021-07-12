package com.testBoot.boot.apps;

import com.testBoot.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication //springboot的启动类， 这个项目的代码需要放在Application同级目录或者同级目录下的目录
@EnableAutoConfiguration
@ComponentScan("com.testBoot.boot") //主程序类所在的包
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