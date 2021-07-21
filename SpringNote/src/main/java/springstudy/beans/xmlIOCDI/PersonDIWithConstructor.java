package springstudy.beans.xmlIOCDI;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;
import java.util.List;

public class PersonDIWithConstructor implements InitializingBean, DisposableBean {
    private String name;
    private List books;

    @Override
    //@PreDestroy
    //如果不使用实现接口的形式规定方法为容器销毁对象前调用，可以在不实现接口的同时加上注解@PreDestroy
    public void destroy() throws Exception {
        //会在bean销毁前调用

    }

    @Override
    //@PostConstruct
    //如果不使用实现接口的形式规定方法为容器初始化对象后调用，可以在不实现接口的同时加上注解@PostConstruct
    public void afterPropertiesSet() throws Exception {
        //在创建好并且属性赋值完成后调用

    }

    //xml默认是无参初始化
    public PersonDIWithConstructor() {
    }

    public PersonDIWithConstructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //用于初始化对象
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}
