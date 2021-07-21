package springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import springstudy.aop.annotation.AOPConfig;
import springstudy.aop.annotation.UserAnnotationAOP;
import springstudy.beans.annotationBeanIOC.PetKeeper;
import springstudy.beans.javaconfig.MyConfig;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;
import springstudy.beans.xmlIOCDI.StudentDIWithSet;


public class Application {
    public static void main(String[] args) {
        //获取上下文,把内部所有的bean实例化
        ApplicationContext context = new ClassPathXmlApplicationContext("springstudy/application.context.xml");
        //测试getbean
        getbeanTest(context);
        //测试注解aop
        //AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        //aopAnnotation(annotationContext);
        //测试注册对象
        //testGenericApplicationContext();
    }
    public static void testGenericApplicationContext(){
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.refresh();    //清空context
        //注册对象给spring进行管理
        genericApplicationContext.registerBean(UserAnnotationAOP.class,()->new UserAnnotationAOP());
        //genericApplicationContext.registerBean("user",UserAnnotationAOP.class,()->new UserAnnotationAOP());
        //获取
        System.out.println(genericApplicationContext.getBean("springstudy.aop.annotation.UserAnnotationAOP"));
        //System.out.println(genericApplicationContext.getBean("user"));
    }
    //缺少jdbc配置无法启动 一直报错
    //aop注解驱动
    public static void aopAnnotation(ApplicationContext context){
        //获取UserAnnotationAOP类的对象
        UserAnnotationAOP userAnnotationAOP = context.getBean("userAnnotationAOP", UserAnnotationAOP.class);
        userAnnotationAOP.login();

    }
    public static void getbeanTest(ApplicationContext context){
        //手动装配
        //通过输入对象名 获取对象。 测试构造器di
        PersonDIWithConstructor person =(PersonDIWithConstructor) context.getBean("person");
        System.out.println(person.getBooks());
        //通过输入对象名 获取对象。 测试setdi
        StudentDIWithSet student = context.getBean("student",StudentDIWithSet.class);
        System.out.println(student.getBooks()[1]);
        //工厂bean
        PersonDIWithConstructor myfactorybean = context.getBean("myfactorybean", PersonDIWithConstructor.class);
        //一般这里都是工厂模式，获取的时候"myfactorybean"一般返回的是factory制造的对象，而"&myfactorybean"返回工厂本身
        System.out.println(myfactorybean);

        //自动装配
        PetKeeper petkeeper = context.getBean("petKeeper", PetKeeper.class);
        System.out.println(petkeeper.getAge());

        //JavaConfig测试 参数是带有componentscan注解的类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        PersonDIWithConstructor james = applicationContext.getBean("James", PersonDIWithConstructor.class);
        System.out.println(james);
    }
}
