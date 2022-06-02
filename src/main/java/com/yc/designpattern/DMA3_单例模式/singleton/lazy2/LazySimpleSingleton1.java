package com.yc.designpattern.DMA3_单例模式.singleton.lazy2;


//懒汉式单例
//在外部需要使用的时候才进行实例化
public class LazySimpleSingleton1 {


    private LazySimpleSingleton1(){}
    //静态块，公共内存区域
    private static LazySimpleSingleton1 lazy = null;

//    public static LazySimpleSingleton1 getInstance(){
//        if(lazy == null){
//            lazy = new LazySimpleSingleton1();
//        }
//        return lazy;
//    }


    public synchronized static LazySimpleSingleton1 getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton1();
        }
        return lazy;
    }

    /*
    这段代码其实是分为三步执行：


     */
}
