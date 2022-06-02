package com.yc.designpattern.DMB22_状态模式.DM3_project;

/**
 * @program: design-pattern-yc
 * @description: 登录状态 LoginState 类  :可以直接加购物车， 可以购买
 * @author: zy
 * @create: 2022-05-23 09:44
 */
public class LoginState extends UserState {

    @Override
    public void addShopping() {
        //在登录状态下，可以直接加购物车
        System.out.println("加购物车成功");
    }

    @Override
    public void buy(String buy) {
        //在登录状态下，可以直接加购物
        System.out.println(buy);
    }
}