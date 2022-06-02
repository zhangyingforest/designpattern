package com.yc.designpattern.DMA3_单例模式.singleton.threadlocal6;


/**
 * ThreadLocal不能保证其创建的对象是全局唯一的，但能保证单个线程中是唯一的。
 *    线程id      Map
 *     A         Map
 *     B         Map
 *     C         Map
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
