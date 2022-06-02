package com.yc.designpattern.DMA3_单例模式.DM1;

/**
 * 测试类
 */
public class SingletonPatternDemo {

   public static void main(String[] args) {
 
      //不合法的构造函数
      //编译时错误：构造函数 SingleObject() 是不可见的
      //SingleObject object = new SingleObject();
 
      //获取唯一可用的对象
      SingleObject object = SingleObject.getInstance();
 
      //显示消息
      object.showMessage();

      SingleObject obj2=SingleObject.getInstance();
      System.out.println(   object+"\t"+obj2);
   }
}