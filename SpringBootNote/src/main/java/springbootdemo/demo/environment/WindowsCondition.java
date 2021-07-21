package springbootdemo.demo.environment;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    //判断是不是windows系统
    //conditioncontext是判断条件能使用的上下文环境
    //annotedmetadata 注释信息
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取ioc的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取环境
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类 可以给容器中注册bean
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean containsBeanDefinition = registry.containsBeanDefinition("person");
        if(environment.getProperty("os.name").contains("windows")) return true;
        return false;
    }


}
