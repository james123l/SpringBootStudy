package springstudy.beans.factorybean;


import org.springframework.beans.factory.FactoryBean;
import springstudy.beans.xmlIOCDI.PersonDIWithConstructor;

/*
* FACTORYBEAN 是定义类型和返回类型不一样，return语句后面返回的是工厂new的object
* */
public class MyFactoryBean implements FactoryBean<PersonDIWithConstructor> {
    //定义返回bean
    @Override
    public PersonDIWithConstructor getObject() throws Exception {
        //实际上这里应该是个生产Person的工厂
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
