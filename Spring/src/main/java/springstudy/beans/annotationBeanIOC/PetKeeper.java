package springstudy.beans.annotationBeanIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
//声明为组件，默认名为类名首字母小写petKeeper 也可以@Component(value = "abc")把组件命名为abc，相当于标签id
/*component 组件annotation还有三个衍生注解，这四个注解功能完全相同可以相互替代
@Repository 常用于标记持久层DAO层
@service    常用于标记服务层
@controller 常用于标记控制层
 */
@Scope("singleton")
//定义为周期为单例模式
public class PetKeeper {
    @Value("1")
    //value注解可以注入基本数据类型和string，这个注解也可以写在set方法上，等价
    private int age;

    @Autowired
    //@Autowired(required = false) 说明可以为null， 注解参数可以不写 默认是true
    //是bytype实现 根据同样的类找(如果有且仅有一个xmlbean是Dog类，就会给这个dog装配xmlbean对象，否则报错)
    @Qualifier(value = "dog")
    //qualifier是可选的可以不写，当autowired不能唯一的自动装配的时候，需要根据qualifier找到dog01的xmlbean对象装配给dog属性
    private Dog dog;

    @Resource(name = "cat")
    @Nullable
    //@resource是java自带的xml配置注解，比autowired更加强大但是更慢，默认先找和cat名称相符的xmlbean，也可以@Resource(name="cat1")查找id=cat1的bean对象，如果没有再根据同样的类找(如果有且仅有一个xmlbean是Cat类，就会给这个cat装配xmlbean对象，否则报错)
    private Cat cat;

    //@nullable注解可以注解可以标注在方法、字段、参数之上，表示对应的值可以为空
    //@NonNull可以标注在方法、字段、参数之上，表示对应的值不可以为空
    public PetKeeper(@Nullable Dog dog,@Nullable Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PetKeeper{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
