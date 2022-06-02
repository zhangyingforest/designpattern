package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class FactoryProducer {

   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }

}
//  jdbc 接口  ->　ｍｙｓｑｌ  实现类
        // ->  oracle
       // ...