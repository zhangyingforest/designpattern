package com.yc.designpattern.DMA8_代理模式.simpleproxy;



public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
