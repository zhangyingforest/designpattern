package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

/**
 * 测试类
 */
public class PrototypePatternDemo {


   public static void main(String[] args) {
      ShapeCache.loadCache();  //首先加载 类的原型实例.


      //以下操作获取原型的克隆对象.
      Shape clonedShape = (Shape) ShapeCache.getShape("1");
      //在这里可以对这个对象进行值 的设置，想像一下，如果这个对象有多个值 要设置的话，避免了创建对象的消耗.
      System.out.println("Shape : " + clonedShape.getType()+"  "+clonedShape);

      Shape cs2 = (Shape) ShapeCache.getShape("1");
      //在这里可以对这个对象进行值 的设置，想像一下，如果这个对象有多个值 要设置的话，避免了创建对象的消耗.
      cs2.setId("333");
      // *******注意两次获取的对象不同,这叫原型模式
      System.out.println("Shape : " + cs2.getType()+"   "+cs2 );

      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
      System.out.println("Shape : " + clonedShape2.getType());        
 
      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
      System.out.println("Shape : " + clonedShape3.getType());

      //默认情况下: clone()是一个浅克隆.
      System.out.println(  "两次产生的对象中的 引用类型的属性值(地址) 是相等的:"+  ( clonedShape.values==cs2.values )  );
      //这说明： 当对clonedShape中的 values进行修改时， cs2.values也会变，这肯定是不被 允许 .
      clonedShape.values.add("abc");  //  cs2.values也会变
      for(   Object o:cs2.values){
         System.out.println(   o );
      }
      // 下面改为深克隆来完成对对象属性值 的复制.



   }
}