package com.yc.designpattern.DMA8_代理模式.DM1;

/**
 * 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 */
public class RealImage implements Image {
 
   private String fileName;
 
   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }
 
   @Override
   public void display() {

      System.out.println("Displaying " + fileName);

   }
 
   private void loadFromDisk(String fileName){
      System.out.println("Loading " + fileName);
   }
}