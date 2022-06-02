package com.yc.designpattern.DMA7_装饰者模式.doc;

import org.springframework.cache.transaction.TransactionAwareCacheDecorator;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;

import java.io.*;

/**
 * @program: design-pattern-yc
 * @description: 装饰器模式在源码中的体现
 * @author: zy
 * @create: 2022-04-25 09:39
 */
public class Test_decorator {
    public static void main(String[] args) throws IOException {
        //java.io
        InputStream dis = new BufferedInputStream(  new DataInputStream(new FileInputStream("d:\\abc.txt")) );
        int read = dis.read();

        //spring中的表现：  1。 Wrapper类      2. Decorator类
        //在 Spring 中，TransactionAwareCacheDecorator 类相当于装饰器模式中的抽象装饰角色，主要用来处理事务缓存
        TransactionAwareCacheDecorator tacd;  // TransactionAwareCacheDecorator 就是对 Cache 的一个包装。


        //springMVC: 下面再来看一个 MVC 中的装饰器模式：HttpHeadResponseDecorator 类，相当于装饰器模式中的具体装饰角色。
        HttpHeadResponseDecorator hhrd;

        //Spring Session就是其中之一，Spring Session通过SessionRepositoryRequestWrapper继承ServletRequestWrapper，扩展了Request，并在SessionRepositoryFilter通过调用过滤链filterChain.doFilter(strategyRequest, strategyResponse);将装饰的Request传入下一流程
    }
}
