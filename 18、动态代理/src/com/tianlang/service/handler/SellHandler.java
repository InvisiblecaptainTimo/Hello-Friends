package com.tianlang.service.handler;

import com.tianlang.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理类，实现代理类的功能（调用目标方法、功能增强）
public class SellHandler implements InvocationHandler {
    public Object target = null;

    // 活动的，传入谁，就给谁创建代理
    public SellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        //float price = factory.sell(amount);   原方式调用目标函数
        res = method.invoke(target,args);   //动态代理的方式

        // price = price + 20; 原方式实现功能增强
        if (res != null){
            Float price = (Float)res;
            price = price + 20;
            res = price;
        }
        return res;
    }
}
