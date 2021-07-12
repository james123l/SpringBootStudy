package hibernateStudy.api.query;

import hibernateStudy.configs.bean.onetomanymapping.Contact;
import hibernateStudy.configs.bean.onetomanymapping.Customer;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

/*
* 对象导航查询
* 应用场景： 根据某个Customer 查询这个对象所有的Contact
* */
public class ObjectNavigateQuery {
    public Set objectNavigateQuery(int id){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //获取customer
            //两种检索策略
            //get是立即查询
            Customer customer = session.get(Customer.class, id);
            //load是延迟查询  类级别延迟：因为是通过id查询，如果接下来调用这个对象id，则不会立刻查询，如果调用对象其他属性则会调用sql查询语句
            //Customer customer = session.load(Customer.class, id);

            //获取set 关联级别延迟： 如果此时调用的是load， 因为contact和customer有主键关联 此时load并没有发送sql语句，如果接下来调用set里的值 则会发送sql
            Set<Contact> contact = customer.getSetContact();
            return contact;
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }
}
