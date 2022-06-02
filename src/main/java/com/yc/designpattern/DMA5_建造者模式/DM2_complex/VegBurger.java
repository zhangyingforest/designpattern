package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

//蔬菜包
public class VegBurger extends Burger {
 
   @Override
   public float price() {
      return 25.0f;
   }
 
   @Override
   public String name() {
      return "蔬菜包";
   }
}