package com.yc.designpattern.DMB23_访问者模式.DM1;

//具体的元素类:包装数据
public class Mouse  implements ComputerPart {
   //TODO:这里是每个类具体的数据

 
   @Override
   public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);  //处理功能分开, 包装功能
   }
}