package com.yc.designpattern.DMB22_状态模式.DM3_project;

/**
 * @program: design-pattern-yc
 * @description: 非登录状态.
 * @author: zy
 * @create: 2022-05-23 09:45
 */
public class NonLoginState extends UserState {

    //非登录态时，要先到登录页面，完成登录后，再购买
    @Override
    public void addShopping() {
        this.jumpLogin();
        //在jumpLogin()中完成登录后，取出当前最新的状态, 才能 加入购物车》
        this.context.getState().addShopping();
    }
    @Override
    public void buy(String buy) {
        this.jumpLogin();
        this.context.getState().buy(buy);
    }
    private void jumpLogin() {
        System.out.println("跳转到登录页面！");
        //TODO:执行登录操作
        this.context.setState(Context.STATE_LOGIN);   //登录完成后， *****修改当前的状态》
    }
}
