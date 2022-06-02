package com.yc.designpattern.DMA3_单例模式.singleton.lazy2;

//懒汉式单例

//这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
//完美地屏蔽了这两个缺点
public class LazyInnerClassSingleton3 {
    //默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyInnerClassSingleton3(){
    }


    //static 是为了使单例的空间共享保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton3 getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        //因为加了final , 保证了
        // 当构造函数结束时，final类型的值是被保证其他线程访问该对象时，它们的值是可见的
        private static final LazyInnerClassSingleton3 LAZY = new LazyInnerClassSingleton3();
    }
}
