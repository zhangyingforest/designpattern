package com.yc.designpattern.DMB21_中介者模式.DM1;

import java.util.Date;

/**
 * 具体中介者（Concrete Mediator）角色
 */
public class ChatRoom {

   //发送信息
   public static void showMessage(User user, String message){
      System.out.println(new Date().toString()
         + " [" + user.getName() +"] : " + message);
   }
}