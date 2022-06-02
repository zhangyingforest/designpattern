package com.yc.designpattern.DMB18_命令模式.DM1;

public class Stock {

   private String name = "ABC";
   private int quantity = 10;

   public void buy(){
      System.out.println("股票 [ 公司名: "+name+",数量: " + quantity +" ] 买");
   }

   public void sell(){
      System.out.println("股票 [ 公司名: "+name+",数量: " + quantity +" ] 卖");
   }
}
