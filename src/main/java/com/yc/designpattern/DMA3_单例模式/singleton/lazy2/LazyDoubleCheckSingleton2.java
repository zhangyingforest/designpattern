package com.yc.designpattern.DMA3_单例模式.singleton.lazy2;


public class LazyDoubleCheckSingleton2 {
    //注意volatile:内存可见性.
    private volatile static LazyDoubleCheckSingleton2 lazy = null;

    private LazyDoubleCheckSingleton2(){}

    public static LazyDoubleCheckSingleton2 getInstance(){
        //为什么要双重检查  lazy==null
        if(lazy == null){
            //在些阻塞并不是基于整 个LazySimpleSingleton2的阻塞，而是在getInstance内部的阻塞，。
            synchronized (LazyDoubleCheckSingleton2.class){  //性能上稍逊
                if(lazy == null){
                    lazy = new LazyDoubleCheckSingleton2();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置lazy指向刚分配的内存地址
                    //4.初次访问对象
                }
            }
        }
        return lazy;
    }



}
