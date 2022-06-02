package com.yc.designpattern.DMB16_迭代子模式.DM1;

/**
 * 测试类
 */
public class IteratorPatternDemo {
   
   public static void main(String[] args) {
      //名字的容器
      NameRepository namesRepository = new NameRepository();

//      Iterator ite= namesRepository.iterator();
//      while(  ite.hasNext() ){
//         Object name= ite.next();
//         System.out.println(    name );
//      }

 
      for(Iterator<String> iter = namesRepository.iterator(); iter.hasNext();       ){
         String name = iter.next();
         System.out.println("Name : " + name);
      }
   }
}