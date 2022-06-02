package com.yc.designpattern.DMA10_桥接模式.pro1;

/**
 * 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现
 * 邮件消息的实现类
 */
public class EmailMsg implements IMsg {
    @Override
    public void send(String msg, String toUser) {
        System.out.println("使用邮件消息发送" + msg + "给" + toUser);
    }
}

/**
 * 短信消息的实现类
 */
class SmsMsg implements IMsg {
    @Override
    public void send(String msg, String toUser) {
        System.out.println("使用短信消息发送" + msg + "给" + toUser);
    }
}
