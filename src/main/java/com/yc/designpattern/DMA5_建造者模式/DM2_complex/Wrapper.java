package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

//打包
public class Wrapper implements Packing {
 
   @Override
   public String pack() {
      return "打纸包";
   }
}