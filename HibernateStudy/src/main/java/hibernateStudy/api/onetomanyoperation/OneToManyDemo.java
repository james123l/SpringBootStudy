package hibernateStudy.api.onetomanyoperation;

import hibernateStudy.configs.bean.onetomanymapping.Contact;
import hibernateStudy.configs.bean.onetomanymapping.Customer;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class OneToManyDemo {
    //一对多级联添加
    public void addOneToMany(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //创建对象
            Customer customer = new Customer();
            customer.setCustName("Google");
            customer.setCustLevel("vip");
            customer.setCustSource("online");
            customer.setCustPhone("123456789");
            customer.setCustMobile("123416569");
            Contact contact = new Contact();
            contact.setCon_gender("f");
            contact.setCon_phone("3558848885");
            contact.setCon_name("Lily");
            //关联
            customer.getSetContact().add(contact);
            //contact.setCustomer(customer); 如customer配置文件设置set的save-update 这里可以不写

            //session save方法
            session.save(customer);
            //session.save(contact); 如customer配置文件设置set的save-update 这里可以不写
            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
    //一对多级联删除
    public void deleteOneToMany(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //先查找要删除的对象
            Customer customer = session.get(Customer.class, 1);
            //删除
            session.delete(customer);

            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
    //一对多修改从表数据
    public void updateOneToMany(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //先查找对象
            Customer customer = session.get(Customer.class, 1);
            Contact contact = session.get(Contact.class, 1);
            //修改
            contact.setCustomer(customer);
            customer.getSetContact().add(contact);

            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
}
