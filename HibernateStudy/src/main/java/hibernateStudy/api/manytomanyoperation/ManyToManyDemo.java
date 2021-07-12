package hibernateStudy.api.manytomanyoperation;


import hibernateStudy.configs.bean.manytomanymapping.GameUser;
import hibernateStudy.configs.bean.manytomanymapping.Role;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

// 两张表本身没有外键链接，通过连接外键到第三张表创建链接
public class ManyToManyDemo {
    //多对多级联保存
    public void addGameUserWithRole(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();
            
            //添加两个用户 并给每个用户添加两个对象
            GameUser user1 = new GameUser(); GameUser user2 = new GameUser();
            user1.setUser_name("Mary"); user1.setUser_password("1234");
            user2.setUser_name("Jim");  user2.setUser_password("4321");
            Role role1 = new Role(); Role role2 = new Role(); Role role3 = new Role();
            role1.setRole_name("manager"); role2.setRole_name("developer"); role3.setRole_name("programmer");
            //建立关联
            user1.getRoleSet().add(role1); user1.getRoleSet().add(role2);
            user2.getRoleSet().add(role2); user2.getRoleSet().add(role3);
            //session save方法
            session.save(user1);
            session.save(user2);
            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
    //多对多级联删除
    //一般不用 因为删除了不能删除的数据 导致关联表紊乱
    public void deleteManyToMany(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //先查找要删除的对象
            GameUser gameUser = session.get(GameUser.class, 1);
            //删除
            session.delete(gameUser);

            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
    //多对多级联修改
    public void addDeleteRoleForUser(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            //开启事务
            transaction = session.beginTransaction();

            //让某个user具有role
            GameUser user = session.get(GameUser.class, 1);
            Role role = session.get(Role.class, 1);
            user.getRoleSet().add(role);
            //让某个user不具有role
            Role delete = session.get(Role.class, 2);
            user.getRoleSet().remove(delete);

            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
}
