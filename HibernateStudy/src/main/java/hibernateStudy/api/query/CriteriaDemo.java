package hibernateStudy.api.query;

import hibernateStudy.configs.bean.User;
import hibernateStudy.configs.bean.onetomanymapping.Customer;
import hibernateStudy.utils.HibernateUtils;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CriteriaDemo {
    public List<User> getAllUsers(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //HQL: from 实体类名 可以获得表内所有信息
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        return null;
    }
}
