package com.yc.designpattern.DMB22_状态模式.DM3_project;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-23 09:48
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        //没有登录的情况下直接加购物车 会先跳到登录页面》
        context.addShopping();
        context.buy("直接购买");
    }
}
