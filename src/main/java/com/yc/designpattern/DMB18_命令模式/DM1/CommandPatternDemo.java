package com.yc.designpattern.DMB18_命令模式.DM1;

/**
 * 测试类
 */
public class CommandPatternDemo {
   public static void main(String[] args) {
      Stock abcStock = new Stock();  //创建股票对象

      //创建命令
      BuyStock buyStockOrder = new BuyStock(abcStock);
      SellStock sellStockOrder = new SellStock(abcStock);

      //按顺序发布股票 买卖 指令
      Broker broker = new Broker();

      broker.takeOrder(buyStockOrder);
      broker.takeOrder(sellStockOrder);

      //统一执行所有的命令
      broker.placeOrders();
   }
}