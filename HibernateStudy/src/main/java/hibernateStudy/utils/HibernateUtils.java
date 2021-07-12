package hibernateStudy.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateUtils {
    //hibernate4
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    //hibernate 5
    private static StandardServiceRegistry registry = null;
    static{
        try{
            //hibernate 4 写法
            //加载核心配置文件 到src找到hibernate.cfg.xml 并加载到对象里
            configuration = new Configuration();
            configuration.configure();
            //创建sessionFactory 会根据对象，映射配置创建表 过程中很消耗性能 所以需要把这一步放在同步代码块中一次创建多次使用
            sessionFactory = configuration.buildSessionFactory();
            //hibernate5
            //注册服务对象
            registry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(registry).buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //hibernate4
    public static Session getCurrentThreadSession(){
        //获取本地线程绑定的session
        //getCurrentSession不需要手动关闭session 否则报错
        //openSession方法需要手动关闭
        return sessionFactory.getCurrentSession();
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
