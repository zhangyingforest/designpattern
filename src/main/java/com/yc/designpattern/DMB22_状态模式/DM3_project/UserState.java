package com.yc.designpattern.DMB22_状态模式.DM3_project;


/**
 * @program: design-pattern-yc
 * @description: 抽象状态角色 UserState 类，用来定义不同状态下需要执行的方法
 * @author: zy
 * @create: 2022-05-23 09:44
 */
public abstract class UserState {


    //上下文对象: 它存有当前用户的状态
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }


    //待执行的操作
    //加入购物车
    public abstract void addShopping();
    //购物
    public abstract void buy(String buy);

}
