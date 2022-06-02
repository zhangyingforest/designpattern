package com.yc.designpattern.DMB22_状态模式.DM4_project2;

/**
 * @program: design-pattern-yc
 * @description: 订单实体类
 * @author: zy
 * @create: 2022-05-23 10:21
 */
public class Order {
    private int id;
    //更多的信息...


    //TODO: 订单的状态枚举
    private OrderStatus status;

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override

    public String toString() {
        return "订单号：" + id + ", 订单状态：" + status;
    }

}

