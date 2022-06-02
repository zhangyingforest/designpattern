package com.yc.designpattern.DMA3_单例模式.singleton.lazy2;

/**
 * @program: design-pattern-yc
 * @description: 懒汉单例在多线程场景下的情况
 * @author: zy
 * @create: 2022-04-21 10:36
 */
public class Test_LazySimpleSingleton1 {
    public static void main(String[] args) {
        Thread t1=new Thread(   new ExectorThread() );
        Thread t2=new Thread( new ExectorThread() );
        t1.start();
        t2.start();
    }
}

//通过断点来观察 懒汉单例的问题
class ExectorThread implements Runnable{

    @Override
    public void run() {
        //在断点上右击， 选择  suspend  ->   thread 模式.
        LazyInnerClassSingleton3 singleton=LazyInnerClassSingleton3.getInstance();
        System.out.println(   Thread.currentThread().getName()+":"+singleton );
    }
}
