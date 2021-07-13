package springbootdemo.demo.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
使用yaml的方式绑定
 */
@ConfigurationProperties(prefix="person")
@Component
@Data
@ToString
public class Person {
    private String name;
    private Boolean boss;
    private Date birthday;
    private Integer age;
    private String[] interests;
    private Pet pet;
    private List<String> animal;
    private Map<String,Object> score;
    private Set<Double> salarys;
    private Map<String,List<Pet>> allPets;
}
