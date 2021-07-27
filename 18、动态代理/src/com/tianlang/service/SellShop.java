package com.tianlang.service;

import com.tianlang.service.handler.SellHandler;
import com.tianlang.service.impl.Factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SellShop {
    public static void main(String[] args) {
        // 创建代理对象
        UsbSell factory = new Factory();//创建目标对象
        InvocationHandler handler = new SellHandler(factory);// 创建InvocationHandler对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),handler);//创建代理对象

        //通过动态代理调用目标函数
        float price = proxy.sell(1);
        System.out.println(price);
    }
}
