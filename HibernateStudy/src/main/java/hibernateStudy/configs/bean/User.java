package hibernateStudy.configs.bean;

import java.util.Date;
/*
* hibernate bean 的规范：
* 1. 所有成员变量私有，并且有一个成员作为唯一值与数据库对应
* 2. 具有共有的get set方法
* 3. 不建使用基本数据类型，而是包装类
* */
public class User {
    //1. 所有成员变量私有，并且有一个成员作为唯一值与数据库对应
    //3. 不建使用基本数据类型，而是包装类
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Date createDate;

    //2. 具有共有的get set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                '}';
    }
}
