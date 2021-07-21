package springstudy.aop.annotation;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect //生成代理对象，需要标注在增强类上
@Order //默认最低优先级
public class UserAnnotationAOPProxy {


    //如果提取 必须写在第一位
    //抽取相同的切入点  参数： execution *代表权限修饰 +空格+路径+方法+(..)代表参数
    @Pointcut("execution(* springstudy.aop.annotation.UserAnnotationAOP.login(..))")
    public void joinPoint(){};

    //函数参数加入joinpiont参数，实际也可不加
    //advice（before） 在方法执行前执行 参数： execution *代表权限修饰 +空格+路径+方法+(..)代表参数
    @Before("execution(* springstudy.aop.annotation.UserAnnotationAOP.login(..))")
    public void before(Joinpoint joinpoint){
        System.out.println("before advice...");
    }

    //advice（after） 在方法执行后执行类似于finally
    @After("joinPoint()")
    public void after(){
        System.out.println("after advice...");
    }

    //advice（afterreturning）在return语句执行后执行，会被异常截断  returning决定谁会获取返回值， returning 可以不写
    @AfterReturning(value = "joinPoint()",returning = "")
    public void afterReturning(Object obj){
        System.out.println("after returning advice...get returning"+obj.toString());
    }

    //advice（after throwing） 在异常抛出后执行,throwing可以不写
    @AfterThrowing(value = "joinPoint()",throwing = "exception")
    public void afterThrowing(Exception e){
        System.out.println("after throwing advice...with exception"+e.toString());
    }

    //advice（around） 环绕执行，会被异常截断
    @Around("joinPoint()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //执行前
        System.out.println("around:before advice...");
        proceedingJoinPoint.proceed();
        //执行后
        System.out.println("around:after advice...");
    }
}
