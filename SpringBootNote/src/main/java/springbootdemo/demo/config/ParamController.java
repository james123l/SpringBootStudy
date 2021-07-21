package springbootdemo.demo.config;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ParamController {
    /**
     * 常用注解还有 requestmapping，但是requestmapping没用规定方法
     * @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解   具体来说，@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
     * @PostMapping用于将HTTP post请求映射到特定处理程序的方法注解   具体来说，@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
     */

    //@GetMapping("/car?id=1") //旧的写法
    @GetMapping("/car/{id}/owner/{username}")   //映射链接：car/3(id)/owner/james(username)?age=18&inters=basketball&inters=girl
    public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("username") String username, @PathVariable Map<String,String> pathVars,  //获取路径上的占位符变量id的和username ,不仅可以通过参数名获取 还可通过map获取，但是map必须是string类型
                                      @RequestHeader("User-Agent") String userAgent, @RequestHeader Map<String,String> headerMap, //获取请求头
                                      @RequestParam("age") Integer age, @RequestParam("inters") List<String> inters, @RequestParam Map<String,String> params, //获取路径上的参数 需要格式 变量名= value&...
                                      @CookieValue("_ga") String _ga, @CookieValue("_ga") Cookie cookie  //获取当前对话客户点cookie的值 也可以直接拿到cookie
                                       ){
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("id",id);
        map.put("username",username);
        map.put("userAgent",userAgent);
        map.put("headers",headerMap);
        return map;     //查看pathVar和map的值是否一致
    }

    @PostMapping("/save")
    public Map postMethod(    @RequestBody String content){ //获取请求体(表单内容)，当客户端发送表单的时候
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("content",content);
        return map;
    }
}
