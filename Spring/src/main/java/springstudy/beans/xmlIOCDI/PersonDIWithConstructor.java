package springstudy.beans.xmlIOCDI;


import java.util.List;

public class PersonDIWithConstructor {
    private String name;
    private List books;
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
