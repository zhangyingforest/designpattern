package com.yc.designpattern.DMB22_状态模式.DM3_project;

/**
 * @program: design-pattern-yc
 * @description:  环境类（Context）角色：也称为上下文，它定义了客户端需要的接口，内部维护一个当前状态，并负责具体状态的切换。
 * @author: zy
 * @create: 2022-05-23 09:45
 */
public class Context {
    //创建状态对象
    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UNLOGIN = new NonLoginState();

    //＊＊＊＊＊这是当前所处的状态
    private UserState currentState = STATE_UNLOGIN;  //默认是没有登录

    //实例块， 在构造方法运行前运行.  给  State设置  Context
    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
    }

    public UserState getState() {
        return this.currentState;
    }

    public void addShopping() {
        this.currentState.addShopping();
    }
    public void buy(String buy) {
        this.currentState.buy(buy);
    }
}
