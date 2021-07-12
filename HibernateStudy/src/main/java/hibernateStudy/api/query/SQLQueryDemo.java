package hibernateStudy.api.query;

import hibernateStudy.configs.bean.User;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

/*
* 调用sql语句的api
* */
public class SQLQueryDemo {
    public List<User> getAllUsers(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //HQL: from 实体类名 可以获得表内所有信息
        NativeQuery sqlQuery = session.createSQLQuery("select * from user");
        sqlQuery.addEntity(User.class);
        //如果不设置entity 返回的list内的对象是obj数组形式
        List<User> list =sqlQuery.list();
        return list;
    }
}
