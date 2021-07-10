

package com.testBoot.boot.Controller;


import com.testBoot.boot.bean.Car;
import com.testBoot.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController  //@controller +@ResponseBody
@RequestMapping()
//@RequestMapping("/hello") 访问http://localhost:8080/hello
public class AppController {
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @Autowired
    Person person;
    @RequestMapping("/person")
    //http://localhost:8080/person
    public Person person(){
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