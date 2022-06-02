package com.yc.designpattern.DMA8_代理模式.dynamicproxy.自定义实现jdk动态代理;

import java.lang.reflect.Method;

public class Meipo implements YcInvocationHandler {
    private Object target;

    public Object getInstance(Object person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return YcJdkProxy.newProxyInstance(new YcClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
}
