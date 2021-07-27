package com.tianlang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //创建对象，表示这是一个控制器对象
public class MyController {

    /*加了注解就相当于servlet中doGet方法
    * ModelAndView：是本次请求的结果
    * 如果value的值有多个，就代表多个请求都响应这个方法
    * */
    @RequestMapping(value = "/dosome.do")
    public ModelAndView dosome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("agr","welcom to mvc");
        modelAndView.addObject("jieguo","你好");

//        modelAndView.setViewName("/WEB-INF/view/result.jsp");
//        modelAndView.setViewName("other");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*不能一个请求同时对应两个方法，只能换其他的请求
    @RequestMapping(value = "/mvc")
    public ModelAndView doother(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("结果","ninhao");

        modelAndView.setViewName("other");
        return modelAndView;
    }*/
    @RequestMapping(value = "/doother.do")
    public ModelAndView other(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("结果","hello");

        modelAndView.setViewName("other");
        return modelAndView;
    }
}
