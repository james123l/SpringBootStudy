package springbootdemo.demo.importannotation.importbeandefinationregister;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import springbootdemo.demo.bean.Person;

public class MyBeanDefinationRegister implements ImportBeanDefinitionRegistrar{
    //AnnotationMetadata 当前类的注解信息
    //BeanDefinitionRegistry beandefination注册类
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containsBeanDefinition = registry.containsBeanDefinition("person");
        if(containsBeanDefinition){
            //注册组件
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
            registry.registerBeanDefinition("person1",rootBeanDefinition);
        }
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
    }
}
