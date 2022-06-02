package com.yc.designpattern.DMA3_单例模式.singleton.reflectQuestion3;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design-pattern-yc
 * @description: 测试解决方案
 * @author: zy
 * @create: 2022-04-21 10:58
 */
public class Test2_innerclassSingleton {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //破坏单例
        Class cls= LazyInnerClassSingleton.class;
        //获取构造方法
        Constructor con=cls.getDeclaredConstructor(null);
        //修改访问权限
        con.setAccessible(true);
        //初始化
        Object o1=con.newInstance();
        Object o2=con.newInstance();

        System.out.println(  o1+"   "+o2);
    }
}
