package com.yc.designpattern.DMA8_代理模式.dbroute;


public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
