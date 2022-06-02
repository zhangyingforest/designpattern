package com.yc.designpattern.DMA3_单例模式.singleton.hungry1;


//饿汉式静态块单例
public class HungryStaticSingleton2 {
    //以final保证可见
    private static final HungryStaticSingleton2 hungrySingleton;
    static {
        hungrySingleton = new HungryStaticSingleton2();
    }
    private HungryStaticSingleton2(){}
    public static HungryStaticSingleton2 getInstance(){
        return  hungrySingleton;
    }
}
