package com.yc.designpattern.DMA10_桥接模式.pro1;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-30 09:08
 */
public class Test {
    public static void main(String[] args) {
        IMsg msg = new SmsMsg();
        AbstractMsg abstractMsg = new NomalMsg(msg);
        abstractMsg.sendMsg("请假3天", "zy");

        msg = new EmailMsg();
        abstractMsg = new UrgencyMsg(msg);
        abstractMsg.sendMsg("速批请假申请 ", "zy");
    }

}
