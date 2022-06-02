package com.yc.designpattern.DMA3_单例模式.singleton.seriable4;

import java.io.Serializable;


//反序列化时导致单例破坏
public class SeriableSingleton implements Serializable {

    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //将内存中状态给永久保存下来了

    //反序列化: 将已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象, 在转换过程中会重新创建对象new

    //SeriableSingleton，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private SeriableSingleton(){
        if( SeriableSingleton.LazyHolder.LAZY!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }


    //static 是为了使单例的空间共享保证这个方法不会被重写，重载
    public static final SeriableSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return SeriableSingleton.LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        //因为加了final , 保证了
        // 当构造函数结束时，final类型的值是被保证其他线程访问该对象时，它们的值是可见的
        private static final SeriableSingleton LAZY = new SeriableSingleton();
    }


    //解决方案: 增加一个   readResolve()方法即可.
    private  Object readResolve(){
        return  SeriableSingleton.LazyHolder.LAZY;
    }

}
