package com.yc.designpattern.DMA10_桥接模式.pro1;

/**
 * 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用
 * 抽象消息类
 */
public abstract class AbstractMsg {
    //持有一个实现部分的对象
    IMsg msg;  //实现组合关系
    //构造方法，传入实现部分的对象
    public AbstractMsg(IMsg msg) {
        this.msg = msg;
    }

    //发送消息，委派给实现部分的方法
    public void sendMsg(String msg, String toUser)
    {
        //子类做不同的实现( 重要性  )
        this.msg.send(msg, toUser);
    }
}


/**
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法
 * 普通消息类
 */
 class NomalMsg extends AbstractMsg {
    //构造方法，传入实现部分的对象
    public NomalMsg(IMsg msg) {
        super(msg);
    }
    @Override
    public void sendMsg(String msg, String toUser) {
        //对于普通消息，直接调用父类方法发送消息即可
        super.sendMsg(msg, toUser);
    }
}

/**
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法
 * 加急消息类
 */
 class UrgencyMsg extends AbstractMsg {
    //构造方法
    public UrgencyMsg(IMsg msg) {
        super(msg);
    }
    @Override
    public void sendMsg(String msg, String toUser) {
        msg = "【加急】" + msg;
        super.sendMsg(msg, toUser);
    }
    //扩展它功能，监控某个消息的处理状态
    public Object watch(String msgId) {
        //根据给出的消息编码（msgId）查询消息的处理状态
        //组织成监控的处理状态，然后返回
        return null;
    }
}