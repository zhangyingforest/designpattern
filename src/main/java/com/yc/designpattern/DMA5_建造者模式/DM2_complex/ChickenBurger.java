package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

//鸡肉包
public class ChickenBurger extends Burger {
 
   @Override
   public float price() {
      return 50.5f;
   }
 
   @Override
   public String name() {
      return "鸡肉包";
   }
}