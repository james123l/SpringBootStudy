package hibernateStudy.configs.bean.onetomanymapping;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Integer cid;
    private  String custName;
    private String custLevel;
    private String custSource;
    private String custPhone;
    private String custMobile;

    //一个客户有多个联系人
    //hibernate需要用set集合表示联系人集合
    private Set<Contact> setContact = new HashSet<>();

    public Set<Contact> getSetContact() {
        return setContact;
    }

    public void setSetContact(Set<Contact> setContact) {
        this.setContact = setContact;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }
}
