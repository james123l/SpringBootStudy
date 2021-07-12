package com.testBoot.boot.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController {
    @RequestMapping("jspModelAndView")
    public ModelAndView jspModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","hello,springbok");
        modelAndView.setViewName("jspModelAndView");
        return modelAndView;
    }
}
