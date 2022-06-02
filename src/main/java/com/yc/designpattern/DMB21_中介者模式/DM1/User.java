package com.yc.designpattern.DMB21_中介者模式.DM1;

/**
 * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 * 当User之间要互相传递消息时，由   ChatRoom这个中介者来完成.
 */
public class User {
   private String name;
 
   public String getName() {
      return name;
   }
 
   public void setName(String name) {
      this.name = name;
   }
 
   public User(String name){
      this.name  = name;
   }

   //****发信息
   public void sendMessage(String message){
      //调用中介者来发送.
      ChatRoom.showMessage(this,    message);
   }
}