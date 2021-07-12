package hibernateStudy.api.singletableoperation;

import hibernateStudy.configs.bean.User;
import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;


/*
一级缓存：
1.一级缓存是默认开启的
2.一级缓存的作用范围是从session创建到关闭
3.一级缓存中只能存储持久态数据，即主键id被定义且和session有关联，并且更改持久化数据后不需要调用session的update 就可以自动更新到数据库

一级缓存操作持久态对象的内存过程：
随着session创建，内存中会有一个一级缓存，并参照一级缓存开辟一个副本。获取的一切的持久态对象都会被储存在一级缓存和副本中，但是如果更改这个对象的属性，只会更改一级缓存内的对象。
transaction提交后，副本会和一级缓存做对比，如果不一致则会把一级缓存存入数据库中。

二级缓存：
1.默认关闭 需要配置，常用redis替代。
2.范围是SessionFactory的范围
 */
public class UserCRUD {
    public static void main(String[] args) {
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.addUserIntoDB();
//        System.out.println(userCRUD.getUserFromDBById(1));
//        modifyUsernameById(1,"Tom");
    }
    //增加User进入数据库
    public void addUserIntoDB(){
        Transaction transaction = null;
        //获取session session 类似于JDBC的连接
        try{
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            //开启事务
            transaction = session.beginTransaction();

            //添加
            User user = new User();
            //user.setId(1); 主键不需要设置
            //！！！如果此处设置了id 也不会被存入数据库 ，例如数据库主键id是10 对象设置为5，但是存入后id会自动被更改为11
            user.setUsername("Cole");
            user.setPassword("344555");
            user.setAge(20);
            user.setCreateDate(new Date(System.currentTimeMillis()));
            //session save方法
            session.save(user);
            //提交事务
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
        //关闭session资源
    }
    public User getUserFromDBById(int i){
        try {
            Session session = HibernateUtils.getCurrentThreadSession();
            //查询
            //调用session get方法. 第一个参数是实体类class，第二个是id
            return session.get(User.class, i);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteUserById(int id){
        Transaction transaction = null;
        User user = getUserFromDBById(0);
        try {
            Session session = HibernateUtils.getCurrentThreadSession();
            transaction = session.beginTransaction();
            //第一种方法 常用 ：delete 传入删除的对象
            //session.delete(user);
            //第二种 不常用
            user = new User();
            user.setId(id);
            session.delete(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
    public void modifyUsernameById(int id,String username){
        Transaction transaction = null;
        User user = getUserFromDBById(id);
        //修改值
        user.setUsername(username);
        try{
            Session session = HibernateUtils.getCurrentThreadSession();
            transaction = session.beginTransaction();
            //update先通过uid找到数据库的信息 再根据user进行修改。 因为user是通过数据库或一级缓存找到的持久态对象，所以不调用update也可以存入数据库
            /*
            * 随着session创建，内存中会有一个一级缓存，并参照一级缓存开辟一个副本。获取的一切的持久态对象都会被储存在一级缓存和副本中，但是如果更改这个对象的属性，只会更改一级缓存内的对象。
            * transaction提交后，副本会和一级缓存做对比，如果不一致则会把一级缓存存入数据库中。
            * */
            //save方法也可以实现更改但是不好，因为如果是新的对象并且赋值不全 会导致数据丢失，因为save是把所有的数据都刷新一遍,并且主键会自增
            //还有一个方法是saveOrUpdate：
            // 当对象处于瞬时态即与session无关联并且无id值时执行save
            // 处于Detached状态即有id但是与session无关联时执行update
            //当对象处于持久态 即与session有关联切有id 执行update
            session.update(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!= null) transaction.rollback();
        }
    }
}
