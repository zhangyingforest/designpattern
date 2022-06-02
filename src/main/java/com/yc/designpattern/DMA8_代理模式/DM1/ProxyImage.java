package com.yc.designpattern.DMA8_代理模式.DM1;

/**
 * 代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 */
public class ProxyImage implements Image{
 
   private RealImage realImage;  //******* 1。 目标类的引用
   private String fileName;
 
   public ProxyImage(String fileName){
      this.fileName = fileName;
   }
 
   @Override
   public void display() {
      //前置增强
      if(realImage == null){
         realImage = new RealImage(fileName);
      }
      System.out.println("可以在这里加入增强的功能");


      realImage.display();  //***** 真正调用的还是目标类的方法》


      //后置增强
   }
}