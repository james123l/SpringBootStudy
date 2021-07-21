package springbootdemo.demo.config;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ServletDemo extends HttpServlet {

    /* web容器启动的时候会为每个程序创建servletContext对象，代表当前应用
     * servlet请求，自定义一切的servlet的服务都基于实现httpservlet，doget和dopost两个方法。 实现类对象可以获取反应流 getWriter等
     * HttpServletRequest 是浏览器向服务端请求  HttpServletResponse 是服务端向浏览器响应
     */

    @GetMapping("/servletwrite")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        //共享数据：在这个servlet的保存数据可以被其他servlet使用，需要调用servletContext,注意：这个类必须是httpservlet的实现类
        ServletContext context = this.getServletContext();
        String user = "james";
        context.setAttribute("user",user);  //存入kv
    }
    @RequestMapping("/servletread")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServletContext context = this.getServletContext();
        Object user = context.getAttribute("user");
        System.out.println(user);
    }
}
