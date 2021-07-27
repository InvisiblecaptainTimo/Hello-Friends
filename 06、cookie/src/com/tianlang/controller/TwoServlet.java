package com.tianlang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        int money = 0;
        int xiaofei = 0;
        int balance = 0;
        Cookie card=null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 读取请求头信息，得到用户点餐类型
        int jiaozimoney = 18;
        int gaifanmoney = 15;
        int miantiaomoney = 12;
        String food = request.getParameter("food");
        // 读取Cookie
        Cookie cookie[]=null;
        cookie = request.getCookies();
        // 支付
        for (Cookie card0:cookie){
            String key = card0.getName();
            String vulue = card0.getValue();
            if ("name".equals(key)){
                name = vulue;
            }else if ("money".equals(key)){
                money =Integer.valueOf(vulue);
                if ("饺子".equals(food)){
                    if (jiaozimoney > money){
                        out.println(name+"余额不足");
                    }else {
                        card = new Cookie("money",money-jiaozimoney+"");
                        xiaofei = jiaozimoney;
                        balance = money-jiaozimoney;
                    }
                }else if ("面条".equals(food)){
                    if (miantiaomoney > money){
                        out.println(name+"余额不足");
                    }else {
                        card = new Cookie("money",money-miantiaomoney+"");
                        xiaofei = miantiaomoney;
                        balance = money-miantiaomoney;
                    }
                }else if ("盖饭".equals(food)){
                    if (gaifanmoney > money){
                        out.println(name+"余额不足");
                    }else {
                        card = new Cookie("money",money-gaifanmoney+"");
                        xiaofei = gaifanmoney;
                        balance = money-gaifanmoney;
                    }
                }
            }
        }
        //将Cookie返给用户
        response.addCookie(card);
        //消费记录写入响应体
        out.println(name+"消费"+xiaofei+"余额:"+balance);
    }
}
