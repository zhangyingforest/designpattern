package com.yc.designpattern.DMB18_命令模式.DM1;

public class BuyStock implements Order {
   private Stock abcStock;
 
   public BuyStock(Stock abcStock){
      this.abcStock = abcStock;
   }
 
   @Override
   public void execute() {
      abcStock.buy();
   }
}