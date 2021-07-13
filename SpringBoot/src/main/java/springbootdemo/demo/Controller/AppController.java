

package springbootdemo.demo.Controller;


import springbootdemo.demo.bean.Car;
import springbootdemo.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController  //@controller +@ResponseBody
@RequestMapping()
//@RequestMapping("/hello") 访问http://localhost:8080/hello
public class AppController {
    //获取其他配置文件内的值，在任何类都可以进行这个操作 也可以用@ConfigurationProperties(prefix ="mycar" ) 见car类
    @Value("${me.name}")
    private String myName;
    @Value("${me.age}")
    private Integer myAge;

    @RequestMapping("/meInfo")
    public String meInfo(){
        return myName+':'+myAge;
    }

    @Autowired
    Car car;

    @RequestMapping("/car")
    @ResponseBody
    public Car car(){
        return car;
    }

    @Autowired
    Person person;

    @RequestMapping("/person")
    //http://localhost:8080/person
    public @ResponseBody Person person(){
        return person;
    }

    @RequestMapping("/")
    //http://localhost:8080
    public String rootPage(){
        return "hello,this is my homepage!";
    }


    @GetMapping("/world")
    public String hello(){
        return "hello,world!";
    }
}