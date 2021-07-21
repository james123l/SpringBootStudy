package springstudy.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect //生成代理对象，需要标注在增强类上
@Order(1)   //设置优先级 越小越高
public class UserAnnotationAOPExtraProxy {
    //advice（before） 在方法执行前执行 参数： execution *代表权限修饰 +空格+路径+方法+(..)代表参数
    @Before("execution(* springstudy.aop.annotation.UserAnnotationAOP.login(..))")
    //增强方法也可以不加入参数
    public void before(){
        System.out.println("extra proxy!!! before advice...");
    }
}
