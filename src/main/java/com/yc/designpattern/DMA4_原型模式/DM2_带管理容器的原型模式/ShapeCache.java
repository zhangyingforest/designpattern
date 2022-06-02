package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ShapeCache {
   //用一个容器存好原始对象.
   private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

   //如果要获取某个对象的一个拷贝，则从容器中取出原型， 再调用原型的拷贝方法
   public static Shape getShape(String shapeId) {
      Shape cachedShape = shapeMap.get(shapeId);
      return (Shape) cachedShape.clone();
   }
 
   // 对每种形状都运行数据库查询，并创建该形状
   // shapeMap.put(shapeKey, shape);
   // 例如，我们要添加三种形状( 这就是三种形状的原型, 以用于后期的拷贝 )
   public static void loadCache() {
      Circle circle = new Circle();
      circle.setId("1");
      List list=new ArrayList();
      list.add(1);
      list.add(2);
      circle.setValues(  list   );
      shapeMap.put(circle.getId(),circle);
 
      Square square = new Square();
      square.setId("2");
      shapeMap.put(square.getId(),square);
 
      Rectangle rectangle = new Rectangle();
      rectangle.setId("3");
      shapeMap.put(rectangle.getId(),rectangle);
   }
}