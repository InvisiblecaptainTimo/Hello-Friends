package com.tianlang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //�������󣬱�ʾ����һ������������
public class MyController {

    /*����ע����൱��servlet��doGet����
    * ModelAndView���Ǳ�������Ľ��
    * ���value��ֵ�ж�����ʹ�����������Ӧ�������
    * */
    @RequestMapping(value = "/dosome.do")
    public ModelAndView dosome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("agr","welcom to mvc");
        modelAndView.addObject("jieguo","���");

//        modelAndView.setViewName("/WEB-INF/view/result.jsp");
//        modelAndView.setViewName("other");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /*����һ������ͬʱ��Ӧ����������ֻ�ܻ�����������
    @RequestMapping(value = "/mvc")
    public ModelAndView doother(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("���","ninhao");

        modelAndView.setViewName("other");
        return modelAndView;
    }*/
    @RequestMapping(value = "/doother.do")
    public ModelAndView other(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("���","hello");

        modelAndView.setViewName("other");
        return modelAndView;
    }
}
