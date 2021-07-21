package springstudy.aop.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserAnnotationAOP {
    @Value("James")
    private String name;

    //join point
    public void login(){
        //int i = 1/0; //模拟异常
        System.out.println("user "+this.name +" is loginning...");
    }

    public UserAnnotationAOP() {
    }

    public UserAnnotationAOP(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
