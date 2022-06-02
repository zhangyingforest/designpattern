package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

//汉堡
public abstract class Burger implements Item {
 
   @Override
   public Packing packing() {
      return new Wrapper();
   }
 
   @Override
   public abstract float price();
}