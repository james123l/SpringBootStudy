package springbootdemo.demo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class RequestAttributeController {
    @RequestMapping("/gotopage")
    public String gotoPage(HttpServletRequest request){ //此时因为只有SpringBoot Module一个web app即只有一个servlet，所以需要用success模拟一个servlet
        request.setAttribute("msg","success");
        request.setAttribute("code","200");
        return "forward:/success";  //模拟转发到/success请求
    }

    @ResponseBody   //转发的时候是请求体
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String msg, @RequestAttribute("code") Integer code,   //获取请求信息
                       HttpServletRequest request){      //直接获取servlet请求
        Object msg1= request.getAttribute("msg");
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("annotation_msg",msg);
        map.put("requestMethod_msg",msg1);
        return null;
    }

    /*
    矩阵变量,默认关闭 需要开启
     */
    //  /cars/sell;low=34;brand=byd,audi,bmw  在请求后 矩阵变量的请求路径是；前面的内容 即sell 。 参数是;后面的内容，如果还有路径可以继续写/。
    @GetMapping("/cars/{path}")
    public Map carSell(@MatrixVariable("low") Integer low,@MatrixVariable("brand")  List<String> brand,@PathVariable("path") String path){//获取矩阵变量
        Map<String,Object> map = new HashMap<>();
        map.put("brand",brand);
        map.put("path",path);
        map.put("low",low);
        return map;
    }
    // 矩阵变量遇到相同名
    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossID}/{empID}")
    public Map boss(@MatrixVariable(value="age",pathVar = "bossID") Integer bossAge,    //获取部分path变量的值
                    @MatrixVariable(value="age",pathVar = "empID") Integer empAge){
        return null;
    }

}
