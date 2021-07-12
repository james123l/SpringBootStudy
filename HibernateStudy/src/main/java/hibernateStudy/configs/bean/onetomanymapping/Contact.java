package hibernateStudy.configs.bean.onetomanymapping;

public class Contact {
    private Integer con_id;
    private String con_name;
    private String con_gender;
    private String con_phone;

    //一个联系人只属于一个客户
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCon_id() {
        return con_id;
    }

    public void setCon_id(Integer con_id) {
        this.con_id = con_id;
    }

    public String getCon_name() {
        return con_name;
    }

    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public String getCon_gender() {
        return con_gender;
    }

    public void setCon_gender(String con_gender) {
        this.con_gender = con_gender;
    }

    public String getCon_phone() {
        return con_phone;
    }

    public void setCon_phone(String con_phone) {
        this.con_phone = con_phone;
    }
}
