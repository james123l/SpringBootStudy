package springstudy.beans.xmlIOCDI;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class StudentDIWithSet {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobby;
    private Set<Address> formerAddress;
    private Map<String,String> card;
    private StudentDIWithSet girlfriend;
    private Properties info;

    public StudentDIWithSet getGirlfriend() {
        return girlfriend;
    }

    public void setGirlfriend(StudentDIWithSet girlfriend) {
        this.girlfriend = girlfriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Set<Address> getFormerAddress() {
        return formerAddress;
    }

    public void setFormerAddress(Set<Address> formerAddress) {
        this.formerAddress = formerAddress;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", info=" + info +
                '}';
    }
}
