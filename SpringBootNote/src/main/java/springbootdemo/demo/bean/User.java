package springbootdemo.demo.bean;

public class User {

    String name;
    int age;
    Pet pet;

    public Pet getPet() {
        return pet;
    }

    public User(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(){};
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
