package com.yc.designpattern.DMA10_桥接模式.pro1;


/**
 * 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用
 * 实现消息发送的统一接口
 */
public interface IMsg {
    // 要发送的消息的内容和接收人
    void send(String msg, String toUser);
}
