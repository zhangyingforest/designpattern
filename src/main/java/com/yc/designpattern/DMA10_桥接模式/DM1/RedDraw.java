package com.yc.designpattern.DMA10_桥接模式.DM1;

/**
 *  具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 * 创建实现了 DrawAPI 接口的实体桥接实现类
 */
public class RedDraw implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: "
         + radius +", x: " +x+", "+ y +"]");
   }
}