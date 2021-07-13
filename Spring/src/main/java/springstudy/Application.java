package springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.beans.annotationBeanIOC.PetKeeper;
import springstudy.beans.javaconfig.MyConfig;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;
import springstudy.beans.xmlIOCDI.StudentDIWithSet;

public class Application {
    public static void main(String[] args) {
        //获取上下文,把内部所有的bean实例化
        ApplicationContext context = new ClassPathXmlApplicationContext("springstudy/application.context.xml");
        //测试getbean
        //getbeanTest(context);
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
