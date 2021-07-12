package hibernateStudy.api.query.HQL;


import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/*
* hql查询对象是类和对象，所以from后是类名 字段用的是属性名
* */
public class HQLDemo {
    // from User 查询所有
    public List getAllUsers(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //HQL: from 实体类名 可以获得表内所有信息
        Query query = session.createQuery("from User");
        List list = query.list();
        return list;
    }

    //排序 order by asc/desc
    public static List getCustomerDesc(int id,String name){
        Session session = HibernateUtils.getCurrentThreadSession();

        //HQL语句 给Customer对象起别名c where条件查询
        Query query = session.createQuery("from Customer order by desc ");

        List list = query.list();
        return list;
    }
    //演示聚集函数 求出一共多少customer对象
    public static Object getCustomerCount(){
        Session session = HibernateUtils.getCurrentThreadSession();

        //HQL语句 select
        Query query = session.createQuery("select count(*) from Customer");

        //返回一个对象
        Object obj = query.uniqueResult();
        return obj;
    }
    //查询字段 投影查询
    public static List getCustomerAttributes(){
        Session session = HibernateUtils.getCurrentThreadSession();

        //HQL语句 select后不支持*
        Query query = session.createQuery("select custName from Customer");

        List list = query.list();
        return list;
    }
    //分页查询
    public static List getCustomerLimit(int id,String name){
        Session session = HibernateUtils.getCurrentThreadSession();

        //HQL语句 给Customer对象起别名c where条件查询
        Query query = session.createQuery("from Customer order by desc ");
        //设置分页
        //设置起始页
        query.setFirstResult(0);
        //设置每页个数
        query.setMaxResults(5);

        List list = query.list();
        return list;
    }
    //条件查询
    public static List getCustomerWithIDAndName(int id,String name){
        Session session = HibernateUtils.getCurrentThreadSession();

        //HQL语句 给Customer对象起别名c where条件查询
        Query query = session.createQuery("from Customer c where c.cid = ? and c.custName = ? ");
        //参数： int:问号的位置，从0开始   obj：查询的对象
        query.setParameter(0,id);
        query.setParameter(1,name);

        List list = query.list();
        return list;
    }
    //条件查询-模糊查询
    public static List getCustomerWithFuzzyName(String name){
        Session session = HibernateUtils.getCurrentThreadSession();
        //like子句 模糊查询
        Query query = session.createQuery("from customer c where c.custName like ? ");
        /*
        模糊查询规则： _ 或者% 匹配
         */
        query.setParameter(1,'%'+name+'%');

        List list = query.list();
        return list;
    }
    //hql内连接查询
    public static List innerJoin(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //like子句 模糊查询
        Query query = session.createQuery("from Customer c inner join c.setContact");
        //Query query = session.createQuery("from Customer c inner join fetch c.setContact");
        //普通内连接list内部是数组
        //fetch内连接list内部是对象
        List list = query.list();
        return list;
    }
    public static List leftJoin(){
        Session session = HibernateUtils.getCurrentThreadSession();
        //like子句 模糊查询
        Query query = session.createQuery("from Customer c left join c.setContact");
        //Query query = session.createQuery("from Customer c left join fetch c.setContact");
        //普通左外连接list内部是数组
        //fetch左外连接list内部是对象
        List list = query.list();
        return list;
    }
}
