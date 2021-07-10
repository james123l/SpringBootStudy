package com.testBoot.boot.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//配置绑定方法一
@Component  //组件必须放在容器中
@ConfigurationProperties(prefix ="mycar" )  //与配置文件的mycar后面一一绑定
public class Car {
    private String brand;
    private int carValue;

    public Car() {
    }
    public Car(String brand, int carValue) {
        this.brand = brand;
        this.carValue = carValue;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", carValue=" + carValue +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public int getCarValue() {
        return carValue;
    }

    public void setCarValue(int carValue) {
        this.carValue = carValue;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
