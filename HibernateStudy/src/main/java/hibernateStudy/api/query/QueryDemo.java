package hibernateStudy.api.query;

import hibernateStudy.configs.bean.User;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class QueryDemo {
    public List<User> getAllUsers(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //HQL: from 实体类名 可以获得表内所有信息
        Query query = session.createQuery("from User");
        List list = query.list();
        return list;
    }
}
