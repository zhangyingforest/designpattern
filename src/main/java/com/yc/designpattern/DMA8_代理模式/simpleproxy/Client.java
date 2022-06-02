package com.yc.designpattern.DMA8_代理模式.simpleproxy;

public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
