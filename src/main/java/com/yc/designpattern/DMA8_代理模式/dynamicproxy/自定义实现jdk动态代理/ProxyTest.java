package com.yc.designpattern.DMA8_代理模式.dynamicproxy.自定义实现jdk动态代理;


import com.yc.designpattern.DMA8_代理模式.dynamicproxy.jdkproxy.Girl;
import com.yc.designpattern.DMA8_代理模式.staticproxy.Person;

public class ProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new Meipo().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
