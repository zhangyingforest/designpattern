package com.yc.designpattern.DMA8_代理模式.dynamicproxy.自定义实现jdk动态代理;

import java.lang.reflect.Method;

/**
 * 回调方法
 */
public interface YcInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
