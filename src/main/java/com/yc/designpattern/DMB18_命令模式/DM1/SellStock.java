package com.yc.designpattern.DMB18_命令模式.DM1;

public class SellStock implements Order {
   private Stock abcStock;
 
   public SellStock(Stock abcStock){
      this.abcStock = abcStock;
   }
 
   @Override
   public void execute() {
      abcStock.sell();
   }
}