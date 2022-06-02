package com.yc.designpattern.DMA8_代理模式.dynamicproxy.jdkproxy;

import com.yc.designpattern.DMA8_代理模式.staticproxy.Person;

public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
