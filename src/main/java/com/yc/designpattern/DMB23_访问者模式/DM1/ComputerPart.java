package com.yc.designpattern.DMB23_访问者模式.DM1;

/**
 * @author zy
 * 抽象元素（Element）角色： 声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 */
public interface ComputerPart {
   //要用  computerPartVisitor 对象来对当前的元素进行处理
   //ComputerPartVisitor是一个接口，有处理元素的方法.
   public void accept(ComputerPartVisitor computerPartVisitor);

}