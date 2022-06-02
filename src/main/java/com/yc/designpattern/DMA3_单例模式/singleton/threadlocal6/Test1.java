package com.yc.designpattern.DMA3_单例模式.singleton.threadlocal6;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-04-22 10:47
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(    ThreadLocalSingleton.getInstance() );
        System.out.println(    ThreadLocalSingleton.getInstance() );
        System.out.println(    ThreadLocalSingleton.getInstance() );
        System.out.println(    ThreadLocalSingleton.getInstance() );


    }
}
