package springstudy.beans.factorybean;


import org.springframework.beans.factory.FactoryBean;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;

/*
* FACTORYBEAN 是定义类型和返回类型不一样
* */
public class MyFactoryBean implements FactoryBean<PersonDIWithConstructor> {
    //定义返回bean
    @Override
    public PersonDIWithConstructor getObject() throws Exception {
        return new PersonDIWithConstructor();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
