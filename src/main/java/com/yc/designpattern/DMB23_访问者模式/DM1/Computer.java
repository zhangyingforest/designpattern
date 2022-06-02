package com.yc.designpattern.DMB23_访问者模式.DM1;

//5.对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，
// 通常由 List、Set、Map 等聚合类实现。
public class Computer implements ComputerPart {
   //组合模式：也可以用迭代器替换
   ComputerPart[] parts;
 
   public Computer(){
      parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};      
   } 
 
 
   @Override
   public void accept(ComputerPartVisitor computerPartVisitor) {
      for (int i = 0; i < parts.length; i++) {
         parts[i].accept(computerPartVisitor);
      }
      computerPartVisitor.visit(this);
   }
}

// 组合模式+访问者模式