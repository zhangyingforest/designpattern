package com.yc.designpattern.DMB18_命令模式.DM1;

import java.util.ArrayList;
import java.util.List;
 
public class Broker {
   //组装命令
   private List<Order> orderList = new ArrayList<Order>(); 

   //接收命令，存到命令列表中
   public void takeOrder(Order order){
      orderList.add(order);      
   }

   //循环命令列表，逐个执行.
   public void placeOrders(){
      for (Order order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}