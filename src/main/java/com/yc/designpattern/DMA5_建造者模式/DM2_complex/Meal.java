package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

import java.util.ArrayList;
import java.util.List;
 
public class Meal {
   private List<Item> items = new ArrayList<Item>();    
 
   public void addItem(Item item){
      items.add(item);
   }
 
   public float getCost(){
      float cost = 0.0f;
      for (Item item : items) {
         cost += item.price();
      }        
      return cost;
   }
 
   public void showItems(){
      for (Item item : items) {
         System.out.print("餐品 : "+item.name());
         System.out.print(", 打包方式 : "+item.packing().pack());
         System.out.println(", 价格 : "+item.price());
      }        
   }    
}