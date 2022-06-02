package com.yc.designpattern.DMA3_单例模式.singleton.reflectQuestion3;

import com.yc.designpattern.DMA3_单例模式.singleton.lazy2.LazyInnerClassSingleton3;

import java.lang.reflect.Constructor;

/**
 * @program: design-pattern-yc
 * @description: 上面的单例模式可以使用反射来调用它的构造方法，从而破坏了单例模型.
 * @author: zy
 * @create: 2022-04-21 10:50
 */
public class Test1_reflection {
    public static void main(String[] args) throws Exception {
        //破坏单例
        Class cls=LazyInnerClassSingleton3.class;
        //获取构造方法
        Constructor con=cls.getDeclaredConstructor(null);
        //修改访问权限
        con.setAccessible(true);
        //初始化
        Object o1=con.newInstance();
        Object o2=con.newInstance();

        System.out.println(  o1+" \n  "+o2);
    }
}
