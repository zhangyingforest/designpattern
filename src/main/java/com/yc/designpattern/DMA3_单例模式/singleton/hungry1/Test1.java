package com.yc.designpattern.DMA3_单例模式.singleton.hungry1;

/**
 * @program: design-pattern-yc
 * @description: 饿汉式单例测试
 * @author: zy
 * @create: 2022-04-21 09:29
 */
public class Test1 {
    public static void main(String[] args) {
        HungrySingleton1 h1=  HungrySingleton1.getInstance();
        HungrySingleton1 h2=  HungrySingleton1.getInstance();
        System.out.println(   h1+"   "+h2);


        HungryStaticSingleton2 h3=  HungryStaticSingleton2.getInstance();
        HungryStaticSingleton2 h4=  HungryStaticSingleton2.getInstance();
        System.out.println(   h3+"   "+h4);
    }
}
