package com.yc.designpattern.DMB21_中介者模式.DM1;

/**
 * 测试类
 */
public class MediatorPatternDemo {
   public static void main(String[] args) {
      //同事对象
      User robert = new User("Robert");
      User john = new User("John");

      //robert向john打招呼的信息通过 聊天室  ChatRoom 发出.
      robert.sendMessage("Hi! John!");
      john.sendMessage("Hello! Robert!");
   }
}