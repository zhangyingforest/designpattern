package com.yc.designpattern.DMA8_代理模式.simpleproxy;


public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }


    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request().");
    }

    public void after(){
        System.out.println("called after request().");
    }
}
